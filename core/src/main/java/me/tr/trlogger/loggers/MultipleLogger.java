package me.tr.trlogger.loggers;

import me.tr.trlogger.levels.Level;

import java.util.Arrays;
import java.util.List;

public class MultipleLogger extends Logger {
    private final List<Logger> loggers;

    public MultipleLogger(List<Logger> loggers) {
        this.loggers = loggers;
    }

    public MultipleLogger(Logger... loggers) {
        this.loggers = Arrays.asList(loggers);
    }

    public List<Logger> getLoggers() {
        return loggers;
    }

    @Override
    public void log(String msg, Level level) {
        for (Logger logger : loggers)
            logger.log(msg, level);
    }
}
