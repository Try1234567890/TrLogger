package me.tr.trlogger.loggers.file.changers.file;

import me.tr.trfiles.management.FileManager;
import me.tr.trfiles.management.archives.zip.zipper.Zippers;
import me.tr.trfiles.management.io.writer.streaming.Streamings;
import me.tr.trlogger.loggers.file.changers.Changer;
import me.tr.trtasks.tasks.async.TrAsyncTask;

import java.io.File;
import java.io.IOException;

public abstract class FileChanger implements Changer {
    private final BackupInformation backupInfo;
    private TrAsyncTask task;

    public FileChanger() {
        this.backupInfo = new BackupInformation();
    }

    public FileChanger(BackupInformation backup) {
        this.backupInfo = backup == null ? new BackupInformation() : backup;
    }

    public FileChanger(File backup) {
        this.backupInfo = backup == null ? new BackupInformation() : new BackupInformation(backup);
    }

    public FileChanger(File backup, boolean zip) {
        this.backupInfo = backup == null ? new BackupInformation() : new BackupInformation(backup, zip);
    }

    public BackupInformation getBackupInfo() {
        return backupInfo;
    }

    public TrAsyncTask getTask() {
        return task;
    }

    protected void setTask(TrAsyncTask task) {
        this.task = task;
    }

    @Override
    public void change(File file) {
        backup(file);
        FileManager.delete(file);
        FileManager.createAsFile(file);
    }

    @Override
    public boolean stop(File file) {
        boolean state = true;
        if (getTask() == null) {
            state = start(file);
        }
        getTask().getOptions().setMaxRun(0);
        return state;
    }

    public void backup(File file) {
        if (!getBackupInfo().enabled()) {
            // Backups disabled.
            return;
        }
        File backup = getBackupInfo().file();
        writeBackup(file, backup);
    }

    public void writeBackup(File file, File backup) {
        try {
            if (getBackupInfo().zip()) {
                File zip = new File(backup, ".zip");
                FileManager.createAsFile(zip);
                Zippers.zip(zip, file);
            } else
                Streamings.writeOrThrown(file, backup);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
