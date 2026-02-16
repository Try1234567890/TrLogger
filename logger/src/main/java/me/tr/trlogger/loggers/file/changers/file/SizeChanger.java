package me.tr.trlogger.loggers.file.changers.file;

import me.tr.trfiles.size.Size;
import me.tr.trformatter.utility.Validator;
import me.tr.trtasks.scheduler.TrTaskScheduler;
import me.tr.trtasks.tasks.async.TrAsyncTask;
import me.tr.trtasks.time.TrTime;
import me.tr.trtasks.time.TrTimeUnit;

import java.io.File;

public class SizeChanger extends FileChanger {
    private static final TrTime PERIOD = new TrTime(10, TrTimeUnit.SECONDS);
    private final Size size;

    public SizeChanger(Size size) {
        Validator.isNull(size, "size is null");
        this.size = size;

    }

    public SizeChanger(Size size, BackupInformation backup) {
        super(backup);
        Validator.isNull(size, "size is null");
        this.size = size;
    }

    public SizeChanger(Size size, File backup) {
        super(backup);
        Validator.isNull(size, "size is null");
        this.size = size;

    }

    public SizeChanger(Size size, File backup, boolean zip) {
        super(backup, zip);
        Validator.isNull(size, "size is null");
        this.size = size;

    }

    public Size getSize() {
        return size;
    }

    @Override
    public boolean start(File file) {
        setTask(new TrAsyncTask(PERIOD) {
            @Override
            protected void task() {
                if (Size.file(file).isMajorOrEquals(getSize())) {
                    change(file);
                }
            }
        });
        TrTaskScheduler.task(getTask());
        return true;
    }
}












