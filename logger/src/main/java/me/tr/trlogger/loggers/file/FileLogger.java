package me.tr.trlogger.loggers.file;

import me.tr.trfiles.management.FileManager;
import me.tr.trlogger.levels.Level;
import me.tr.trlogger.loggers.Logger;
import me.tr.trlogger.loggers.file.changers.Changer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends Logger {
    public static File DEF_FILE = new File(System.getProperty("user.dir"), "logs/latest.log");
    private final File file;
    private final Changer changer;

    /**
     * Create a new FileLogger.
     * <p>
     * If {@code file} is null, not exists or is a directory:
     * the {@link #DEF_FILE} will be used instead.
     *
     * @param file    The file where write logs.
     * @param changer The changer used to switch file.
     */
    public FileLogger(File file, Changer changer) {
        if (file == null || !file.exists() || file.isDirectory()) {
            this.file = DEF_FILE;
        } else this.file = file;

        this.changer = changer == null ? Changer.EMPTY : changer;
        this.changer.start(file);
    }

    /**
     * Create a new FileLogger.
     * <p>
     * If {@code file} is null, not exists or is a directory:
     * the {@link #DEF_FILE} will be used instead.
     *
     * @param file The file where write logs.
     */
    public FileLogger(File file) {
        this(file, Changer.EMPTY);
    }

    public File getFile() {
        return file;
    }

    public Changer getChanger() {
        return changer;
    }

    @Override
    public void log(String msg, Level level) {
        if (file.isDirectory()) {
            throw new IllegalArgumentException("the file used for logging (" + getFile().getPath() + ") is a directory");
        }

        if (!file.exists()) {
            FileManager.createAsFile(file);
        }

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(format(msg, level));
            fw.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

}













