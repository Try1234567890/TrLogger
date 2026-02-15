package me.tr.trlogger.loggers;

import me.tr.trformatter.TrFormatterAPI;
import me.tr.trformatter.strings.color.ansi.ANSI;
import me.tr.trlogger.levels.*;

public abstract class TrLogger {
    private boolean debug;

    public abstract void log(String msg, TrLevel level);

    public void info(String msg) {
        log(msg, TrInfo.INFO);
    }

    public void warn(String msg) {
        log(msg, TrWarn.WARN);
    }

    public void error(String msg) {
        log(msg, TrError.ERROR);
    }

    public void debug(String msg) {
        if (!isDebug())
            return;
        log(msg, TrDebug.DEBUG);
    }

    public void info(String... msgs) {
        for (String msg : msgs) log(msg, TrInfo.INFO);
    }

    public void warn(String... msgs) {
        for (String msg : msgs) log(msg, TrWarn.WARN);
    }

    public void error(String... msgs) {
        for (String msg : msgs) log(msg, TrError.ERROR);
    }

    public void debug(String... msgs) {
        if (!isDebug())
            return;
        for (String msg : msgs) log(msg, TrDebug.DEBUG);
    }

    public void info(Throwable t, String msg) {
        log(t + " - " + msg, TrInfo.INFO);
    }

    public void warn(Throwable t, String msg) {
        log(t + " - " + msg, TrWarn.WARN);
    }

    public void error(Throwable t, String msg) {
        log(t + " - " + msg, TrError.ERROR);
    }

    public void debug(Throwable t, String msg) {
        if (!isDebug())
            return;
        log(t + " - " + msg, TrDebug.DEBUG);
    }

    public void info(Throwable t, String... msgs) {
        for (String msg : msgs) log(t + " - " + msg, TrInfo.INFO);
    }

    public void warn(Throwable t, String... msgs) {
        for (String msg : msgs) log(t + " - " + msg, TrWarn.WARN);
    }

    public void error(Throwable t, String... msgs) {
        for (String msg : msgs) log(t + " - " + msg, TrError.ERROR);
    }

    public void debug(Throwable t, String... msgs) {
        if (!isDebug())
            return;
        for (String msg : msgs) log(t + " - " + msg, TrDebug.DEBUG);
    }

    protected String compose(String msg, TrLevel level) {
        return TrFormatterAPI.format(level.ansi() + level.getTag() + " " + msg + ANSI.RESET_TAG + "\n");
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isDebug() {
        return debug;
    }
}
