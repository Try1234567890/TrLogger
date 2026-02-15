package me.tr.trlogger.loggers;

import me.tr.trlogger.levels.TrLevel;

import java.util.Arrays;
import java.util.List;

public class TrMultipleLogger extends TrLogger {
    private final List<TrLogger> loggers;

    public TrMultipleLogger(List<TrLogger> loggers) {
        this.loggers = loggers;
    }

    public TrMultipleLogger(TrLogger... loggers) {
        this.loggers = Arrays.asList(loggers);
    }

    public List<TrLogger> getLoggers() {
        return loggers;
    }

    @Override
    public void log(String msg, TrLevel level) {
        for (TrLogger logger : loggers)
            logger.log(msg, level);
    }
}
