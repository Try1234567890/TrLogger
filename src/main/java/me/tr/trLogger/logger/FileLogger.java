package me.tr.trLogger.logger;

import me.tr.trFiles.general.managers.FileManager;
import me.tr.trLogger.TrLogger;
import me.tr.trLogger.files.Config;
import me.tr.trLogger.files.size.FileSize;
import me.tr.trLogger.formatter.Formatter;
import me.tr.trLogger.levels.TrLevel;

import java.io.*;

public class FileLogger extends Logger {
    private File file;
    private BufferedWriter writer;
    private boolean keepOpen;
    private long maxSize;
    private File moveToAtMaxSize = new File(Formatter.getInstance().format(Config.MAX_SIZE_MOVE_TO.asString()));
    private boolean writing = false;


    public FileLogger(File file, boolean keepOpen) throws IOException {
        this.file = file;
        this.keepOpen = keepOpen;
        FileSize fs = FileSize.parse(Config.FILE_MAX_SIZE.asString());
        this.maxSize = fs != null ? fs.asByte() : Long.MAX_VALUE;
        open();
    }

    public FileLogger(File file) throws IOException {
        this(file, false);
    }

    public FileLogger(String file, boolean keepOpen) throws IOException {
        this(TrLogger.getInstance().getFiles().getFileManager().getFileFromString(Formatter.getInstance().format(file)), keepOpen);
    }

    public FileLogger(String file) throws IOException {
        this(TrLogger.getInstance().getFiles().getFileManager().getFileFromString(Formatter.getInstance().format(file)));
    }

    public FileLogger(boolean keepOpen) throws IOException {
        this(TrLogger.getInstance().getFiles().getFileManager().getFileFromString(Formatter.getInstance().format(Config.FILE_PATH.asString())), keepOpen);
    }

    public FileLogger() throws IOException {
        this(TrLogger.getInstance().getFiles().getFileManager().getFileFromString(Formatter.getInstance().format(Config.FILE_PATH.asString())));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void open() throws IOException {
        if (!this.file.exists()) {
            if (this.file.getParentFile() != null
                    && !this.file.getParentFile().exists()) {
                this.file.getParentFile().mkdirs();
            }
            this.file.createNewFile();
        }
        if (keepOpen && writer != null) {
            return;
        }
        this.writer = new BufferedWriter(new FileWriter(this.file, true));
    }

    private void close() throws IOException {
        if (writer != null) {
            while (true) {
                if (!writing) {
                    writer.close();
                    writer = null;
                    break;
                }
            }
        } else throw new NullPointerException("Error while closing writer. Writer is null.");
    }

    private void change() throws IOException {
        close();
        open();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void move(File toPath) throws IOException {
        if (this.file == null) {
            return;
        }
        FileManager fm = TrLogger.getInstance().getFiles().getFileManager();
        File to = new File(toPath, "\\backup-" + file.getName());
        if (!to.exists()) {
            fm.createFile(to);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(this.file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(to))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
        close();
        this.file.delete();
        this.file = TrLogger.getInstance().getFiles().getFileManager().getFileFromString(Formatter.getInstance().format(Config.FILE_PATH.asString()));
        open();
    }

    @Override
    public void log(String msg, TrLevel level) {
        if (writer == null) {
            return;
        }
        writing = true;
        try {
            writer.append(Formatter.getInstance().format(level.prefix() + ' ' + msg));
            writer.flush();
            if (this.file.length() >= maxSize) {
                move(moveToAtMaxSize);
                return;
            }
            if (!keepOpen) {
                change();
            }
        } catch (IOException e) {
            TrLogger.getInstance().getLogger().error(e, "Error while writing log into " + this.file.getPath());
        } finally {
            writing = false;
        }
    }

    public void setKeepOpen(boolean keepOpen) {
        this.keepOpen = keepOpen;
    }

    public void setFile(File file) {
        try {
            this.file = file;
            change();
        } catch (IOException e) {
            TrLogger.getInstance().getLogger().error(e, "Error while writing log into " + file.getPath());
        }
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }

    public void setMoveToAtMaxSize(File moveToAtMaxSize) {
        this.moveToAtMaxSize = moveToAtMaxSize;
    }
}
