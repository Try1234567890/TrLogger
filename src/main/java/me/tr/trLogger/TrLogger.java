package me.tr.trLogger;

import me.tr.trFiles.TrFiles;
import me.tr.trLogger.files.FileLoader;
import me.tr.trLogger.logger.ConsoleLogger;

import java.io.File;

public class TrLogger {
    private static TrLogger instance;
    private final TrFiles files;
    private final FileLoader fileLoader;
    private final ConsoleLogger logger;

    private TrLogger() {
        instance = this;
        files = new TrFiles();
        fileLoader = new FileLoader();
        logger = new ConsoleLogger();
    }

    public static TrLogger getInstance() {
        if (instance == null) {
            instance = new TrLogger();
        }
        return instance;
    }

    public TrFiles getFiles() {
        return files;
    }

    public FileLoader getFileLoader() {
        return fileLoader;
    }

    public ConsoleLogger getLogger() {
        return logger;
    }

    public void setConfigsDir(File dir) {
        getFileLoader().setConfigsDir(dir);
        getFileLoader().load();
    }

    public void setConfigsDir(String dir) {
        getFileLoader().setConfigsDir(dir);
        getFileLoader().load();
    }
}
