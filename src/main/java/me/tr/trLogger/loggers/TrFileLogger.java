package me.tr.trlogger.loggers;

import me.tr.trformatter.TrValidator;
import me.tr.trlogger.levels.TrLevel;
import me.tr.trfiles.configuration.management.FileManager;
import me.tr.trfiles.configuration.size.TrSizeUnit;
import me.tr.trtasks.TrTaskScheduler;
import me.tr.trtasks.time.TrTime;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class TrFileLogger extends TrLogger {
    private @NotNull File file;
    private Function<File, String> backupNamer;
    private TrFileChanger changer;
    private BufferedWriter writer; // If null means that needs to be re-opened every time.

    /**
     * Create a new FileLogger.
     *
     * @param file           The file to write log into.
     * @param changer        The type of file changer to use.
     * @param backupNamer    The function used to name the backup file.
     * @param keepSameWriter Do not close the writer every time, use always the same instance.
     */
    public TrFileLogger(@NotNull File file, TrFileChanger changer, @NotNull Function<File, String> backupNamer, boolean keepSameWriter) {
        TrValidator.isNull(file, "The file to write log into is null or not exists.");
        TrValidator.isNull(backupNamer, "The backup namer is null.");
        try {
            this.file = file;
            this.backupNamer = backupNamer;
            this.changer = changer;
            this.writer = keepSameWriter ? new BufferedWriter(new FileWriter(file)) : null;
        } catch (IOException e) {
            throw new RuntimeException("An error occur while creating a new Writer: ", e);
        }
    }

    public TrFileLogger(@NotNull File file) {
        this(file, null, (f) -> "backup-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh-mm-ss")) + "." + f.getName(), false);
    }

    @Override
    public void log(String msg, TrLevel level) {
        String composedMSG = compose(msg, level);
        change();
        try {
            BufferedWriter writer = getWriter();
            writer.write(composedMSG);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("An error occurs while writing " + composedMSG + " to " + getFile().getPath(), e);
        }
    }

    public @NotNull File getFile() {
        return file;
    }

    public void setFile(@NotNull File file) {
        TrValidator.isNull(file, "The file to write log into is null or not exists.");
        this.file = file;
    }

    public Function<File, String> getBackupNamer() {
        return backupNamer;
    }

    public void setBackupNamer(Function<File, String> backupNamer) {
        TrValidator.isNull(backupNamer, "The backup namer is null.");
        this.backupNamer = backupNamer;
    }

    public TrFileChanger getChanger() {
        return changer;
    }

    public void setChanger(TrFileChanger changer) {
        this.changer = changer;
    }

    public BufferedWriter getWriter() {
        if (writer == null) {
            try {
                return new BufferedWriter(new FileWriter(getFile(), true));
            } catch (IOException e) {
                throw new RuntimeException("An error occur while creating a new Writer: ", e);
            }
        }
        return writer;
    }

    private void change() {
        if (getChanger() == null)
            return;
        if (getChanger().needsChange())
            backup();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void backup() {
        String fileName = getBackupNamer().apply(getFile());
        File backup = new File(getFile(), fileName);
        File current = getFile();

        getFile().renameTo(backup);
        FileManager.create(current);
    }

    public interface TrFileChanger {
        boolean needsChange();
    }

    public static class TrSizeChanger implements TrFileChanger {
        private final TrFileLogger logger;
        private TrSizeUnit size;

        TrSizeChanger(TrFileLogger logger, TrSizeUnit size) {
            this.logger = logger;
            this.size = size;
        }

        public TrFileLogger getLogger() {
            return logger;
        }

        public TrSizeUnit getSize() {
            return size;
        }

        public void setSize(TrSizeUnit size) {
            this.size = size;
        }

        @Override
        public boolean needsChange() {
            return getLogger().getFile().length() == size.toBytes();
        }
    }

    public static class TrTimeChanger implements TrFileChanger {
        private final TrFileLogger logger;
        private boolean change;


        TrTimeChanger(TrFileLogger logger, TrTime time) {
            TrValidator.isNull(time, "The provided time is null");
            TrValidator.isNull(logger, "The provided logger is null");
            this.logger = logger;
            TrTaskScheduler.getInstance().runDelay(() -> change = true, time);
        }

        TrFileLogger getLogger() {
            return logger;
        }

        public boolean isChange() {
            return change;
        }

        @Override
        public boolean needsChange() {
            return isChange();
        }
    }
}
