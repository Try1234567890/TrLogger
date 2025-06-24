package me.tr.trLogger.logger;

import me.tr.trLogger.files.Config;
import me.tr.trLogger.levels.Levels;
import me.tr.trLogger.levels.TrLevel;

import java.util.Collection;

public abstract class Logger {

    protected abstract void log(String msg, TrLevel level);

    public void info(String... msg) {
        if (msg == null) return;
        for (String line : msg)
            log(line, Levels.INFO.level());
    }

    public void warn(String... msg) {
        if (msg == null) return;
        for (String line : msg)
            log(line, Levels.WARN.level());
    }

    public void error(String... msg) {
        if (msg == null) return;
        for (String line : msg)
            log(line, Levels.ERROR.level());
    }

    public void debug(String... msg) {
        if (msg == null) return;
        if (!Config.DEBUG.asBoolean()) return;
        for (String line : msg)
            log(line, Levels.DEBUG.level());
    }

    public void info(Collection<String> msg) {
        if (msg == null) return;
        for (String line : msg)
            log(line, Levels.INFO.level());
    }

    public void warn(Collection<String> msg) {
        if (msg == null) return;
        for (String line : msg)
            log(line, Levels.WARN.level());
    }

    public void error(Collection<String> msg) {
        if (msg == null) return;
        for (String line : msg)
            log(line, Levels.ERROR.level());
    }

    public void debug(Collection<String> msg) {
        if (msg == null) return;
        if (!Config.DEBUG.asBoolean()) return;
        for (String line : msg)
            log(line, Levels.DEBUG.level());
    }

    public void info(Throwable throwable, String... msg) {
        for (String line : msg)
            log(line + ": \n" + throwable.getMessage(), Levels.INFO.level());
    }

    public void warn(Throwable throwable, String... msg) {
        for (String line : msg)
            log(line + ": \n" + throwable.getMessage(), Levels.WARN.level());
    }

    public void error(Throwable throwable, String... msg) {
        for (String line : msg)
            log(line + ": \n" + throwable.getMessage(), Levels.ERROR.level());
    }

    public void debug(Throwable throwable, String... msg) {
        if (!Config.DEBUG.asBoolean()) return;
        for (String line : msg)
            log(line + ": \n" + throwable.getMessage(), Levels.DEBUG.level());
    }
}