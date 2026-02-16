package me.tr.trlogger.loggers.file.changers.file;

import me.tr.trformatter.utility.Validator;
import me.tr.trtasks.scheduler.TrTaskScheduler;
import me.tr.trtasks.tasks.async.TrAsyncTask;
import me.tr.trtasks.time.TrTime;

import java.io.File;

public class TimeChanger extends FileChanger {
    private final TrTime time;

    public TimeChanger(TrTime time) {
        super();
        Validator.isNull(time, "time is null");
        this.time = time;
    }

    public TimeChanger(TrTime time, BackupInformation backup) {
        super(backup);
        Validator.isNull(time, "time is null");
        this.time = time;
    }

    public TimeChanger(TrTime time, File backup) {
        super(backup);
        Validator.isNull(time, "time is null");
        this.time = time;
    }

    public TimeChanger(TrTime time, File backup, boolean zip) {
        super(backup, zip);
        Validator.isNull(time, "time is null");
        this.time = time;
    }

    public TrTime getTrTime() {
        return time;
    }

    @Override
    public boolean start(File file) {
        setTask(new TrAsyncTask(time) {
            @Override
            protected void task() {
                change(file);
                stop(file);
            }
        });
        TrTaskScheduler.task(getTask());
        return true;
    }
}












