package me.tr.trlogger.loggers.file.changers.file;

import me.tr.trfiles.management.FileManager;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record BackupInformation(boolean enabled, boolean zip, File file) {
    private static String date() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
    }

    public static File DEF_FILE = new File(System.getProperty("user.dir"), "logs/backup-" + date() + ".zip");

    public BackupInformation(boolean enabled, boolean zip, File file) {
        if (file == null || !file.exists() || file.isDirectory()) {
            this.enabled = enabled;
            this.zip = zip;
            this.file = DEF_FILE;
            return;
        }
        this.enabled = enabled;
        this.zip = zip;
        this.file = file;
    }

    public BackupInformation(File file, boolean zip) {
        this(true, zip, file);
    }

    public BackupInformation(File file) {
        this(true, false, file);
    }

    public BackupInformation() {
        this(false, false, DEF_FILE);
    }

    @Override
    public File file() {
        if (!file.exists()) {
            FileManager.createAsFile(file);
            return file;
        }
        if (file.isDirectory()) {
            throw new IllegalArgumentException("The provided file for backup (" + file + ") is a directory");
        }
        return file;
    }
}
