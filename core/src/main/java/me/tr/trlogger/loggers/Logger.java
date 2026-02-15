package me.tr.trlogger.loggers;

import me.tr.trformatter.TrFormatterAPI;
import me.tr.trformatter.strings.color.ansi.ANSI;
import me.tr.trlogger.levels.*;
import me.tr.trlogger.levels.Error;

public abstract class Logger {
    private boolean debug;

    public abstract void log(String msg, Level level);

    public void info(String msg) {
        log(msg, Info.INFO);
    }

    public void warn(String msg) {
        log(msg, Warn.WARN);
    }

    public void error(String msg) {
        log(msg, Error.ERROR);
    }

    public void debug(String msg) {
        if (!isDebug())
            return;
        log(msg, Debug.DEBUG);
    }

    public void info(String... msgs) {
        for (String msg : msgs) log(msg, Info.INFO);
    }

    public void warn(String... msgs) {
        for (String msg : msgs) log(msg, Warn.WARN);
    }

    public void error(String... msgs) {
        for (String msg : msgs) log(msg, Error.ERROR);
    }

    public void debug(String... msgs) {
        if (!isDebug())
            return;
        for (String msg : msgs) log(msg, Debug.DEBUG);
    }

    public void info(Throwable t, String msg) {
        log(t + " - " + msg, Info.INFO);
    }

    public void warn(Throwable t, String msg) {
        log(t + " - " + msg, Warn.WARN);
    }

    public void error(Throwable t, String msg) {
        log(t + " - " + msg, Error.ERROR);
    }

    public void debug(Throwable t, String msg) {
        if (!isDebug())
            return;
        log(t + " - " + msg, Debug.DEBUG);
    }

    public void info(Throwable t, String... msgs) {
        for (String msg : msgs) log(t + " - " + msg, Info.INFO);
    }

    public void warn(Throwable t, String... msgs) {
        for (String msg : msgs) log(t + " - " + msg, Warn.WARN);
    }

    public void error(Throwable t, String... msgs) {
        for (String msg : msgs) log(t + " - " + msg, Error.ERROR);
    }

    public void debug(Throwable t, String... msgs) {
        if (!isDebug())
            return;
        for (String msg : msgs) log(t + " - " + msg, Debug.DEBUG);
    }

    protected String compose(String msg, Level level) {
        return TrFormatterAPI.format(level.ansi() + level.getTag() + " " + msg + ANSI.RESET_TAG + "\n");
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isDebug() {
        return debug;
    }
}
