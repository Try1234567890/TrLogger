package me.tr.trLogger.logger;

import me.tr.trLogger.files.Config;
import me.tr.trLogger.levels.Levels;
import me.tr.trLogger.levels.TrLevel;

public abstract class Logger {

    protected abstract void log(String msg, TrLevel level);

    public void info(String msg) {
        log(msg, Levels.INFO.level());
    }

    public void warn(String msg) {
        log(msg, Levels.WARN.level());
    }

    public void error(String msg) {
        log(msg, Levels.ERROR.level());
    }

    public void debug(String msg) {
        if (!Config.DEBUG.asBoolean())
            return;
        log(msg, Levels.DEBUG.level());
    }

    public void info(Exception ex, String msg) {
        log(msg + " - " + ex.getMessage(), Levels.INFO.level());
    }

    public void warn(Exception ex, String msg) {
        log(msg + " - " + ex.getMessage(), Levels.WARN.level());
    }

    public void error(Exception ex, String msg) {
        log(msg + " - " + ex.getMessage(), Levels.ERROR.level());
    }

    public void debug(Exception ex, String msg) {
        log(msg + " - " + ex.getMessage(), Levels.DEBUG.level());
    }

    public void info(String... msg) {
        for (String line : msg)
            info(line);
    }

    public void warn(String... msg) {
        for (String line : msg)
            warn(line);
    }

    public void error(String... msg) {
        for (String line : msg)
            error(line);
    }

    public void debug(String... msg) {
        for (String line : msg)
            debug(line);
    }

    public void info(Exception ex, String... msg) {
        for (String line : msg)
            info(ex, line);
    }

    public void warn(Exception ex, String... msg) {
        for (String line : msg)
            warn(ex, line);
    }

    public void error(Exception ex, String... msg) {
        for (String line : msg)
            error(ex, line);
    }

    public void debug(Exception ex, String... msg) {
        for (String line : msg)
            debug(ex, line);
    }
}