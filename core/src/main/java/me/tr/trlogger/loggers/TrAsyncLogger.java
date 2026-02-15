package me.tr.trlogger.loggers;

import me.tr.trformatter.utility.Validator;
import me.tr.trlogger.levels.TrLevel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TrAsyncLogger extends TrLogger {
    private static final ScheduledExecutorService service = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    private TrLogger logger;

    public TrAsyncLogger(TrLogger logger) {
        Validator.isNull(logger, "The logger is null");
        this.logger = logger;
    }

    @Override
    public void log(String msg, TrLevel level) {
        Validator.isNull(getLogger(), "The logger is null");
        service.execute(() -> getLogger().log(msg, level));
    }

    public TrLogger getLogger() {
        return logger;
    }

    public void setLogger(TrLogger logger) {
        Validator.isNull(logger, "The logger is null");
        this.logger = logger;
    }
}
