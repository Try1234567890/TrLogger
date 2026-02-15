package me.tr.trlogger.loggers;

import me.tr.trformatter.utility.Validator;
import me.tr.trlogger.levels.Level;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AsyncLogger extends Logger {
    private static final ScheduledExecutorService service = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    private Logger logger;

    public AsyncLogger(Logger logger) {
        Validator.isNull(logger, "The logger is null");
        this.logger = logger;
    }

    @Override
    public void log(String msg, Level level) {
        Validator.isNull(getLogger(), "The logger is null");
        service.execute(() -> getLogger().log(msg, level));
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        Validator.isNull(logger, "The logger is null");
        this.logger = logger;
    }
}
