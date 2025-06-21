package me.tr.trLogger.files;

import me.tr.trFiles.configuration.file.FileConfiguration;
import me.tr.trFiles.configuration.file.yaml.YamlConfiguration;
import me.tr.trFiles.general.managers.FileManager;
import me.tr.trFiles.general.utility.FileUtility;
import me.tr.trLogger.TrLogger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class FileLoader {
    private FileConfiguration config;
    private final TrLogger main = TrLogger.getInstance();
    private final FileManager fm = main.getFiles().getFileManager();
    private final File jar = searchJar(fm.getFileFromString(System.getProperty("user.dir")));
    private File CONFIGS_DIR;
    private final List<String> files = List.of(
            "config.yml"
    );

    public void load() {
        if (this.jar == null || CONFIGS_DIR == null) {
            return;
        }
        for (String fileName : files) {
            File to = fm.getFileFromString(CONFIGS_DIR.getPath() + '\\' + fileName);
            File intoJar = fm.getFileFromString("logger-" + fileName);
            if (!to.exists()) {
                fm.createFile(to);
            }
            FileConfiguration config = to.length() == 0 ? YamlConfiguration.loadFromJar(jar, intoJar, to) : YamlConfiguration.loadConfiguration(to);
            String fieldName = getFieldName(fileName);
            try {
                Field field = getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(this, config);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error while loading TrLogger configs: ", e);
            }
        }
    }

    private String getFieldName(String name) {
        return FileUtility.getFileNameWithoutExtension(name);
    }

    private File searchJar(File path) {
        File[] files = path.listFiles();
        if (files == null) return null;
        for (File file : files) {
            if (file.isDirectory()) {
                File newFile = searchJar(file);
                if (newFile != null) return newFile;
                else continue;
            }
            if (FileUtility.isJar(file)) {
                try (JarFile jar = new JarFile(file)) {
                    JarEntry entry = jar.getJarEntry("me/tr/trLogger/");
                    if (entry != null) return file;
                } catch (IOException _) {
                }
            }
        }
        return null;
    }


    public void setConfigsDir(File dir) {
        this.CONFIGS_DIR = dir;
    }

    public void setConfigsDir(String dir) {
        this.CONFIGS_DIR = fm.getFileFromString(dir);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public File getJar() {
        return jar;
    }
}
