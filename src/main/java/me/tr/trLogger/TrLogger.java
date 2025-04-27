package me.tr.trLogger;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;

public final class TrLogger {
    private boolean debug = false;

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public void log(String message, LoggerLevel level) {
        if (Utility.isPaper()) {
            Component msg = MiniMessage.miniMessage().deserialize('<' + level.getColor().getHexCode() + '>' + level.getPrefix() + ' ' + message);
            Bukkit.getConsoleSender().sendMessage(msg);
            return;
        }
        if (Utility.isWindows()) {
            String msg = level.getColor().toWinTerminalTag() + level.getPrefix() + ' ' + message;
            Bukkit.getConsoleSender().sendMessage(msg);
            return;
        }
        String msg = level.getColor().getCharCode() + level.getPrefix() + ' ' + message;
        Bukkit.getConsoleSender().sendMessage(msg);
    }


    public void info(String message) {
        log(message, LoggerLevel.INFO);
    }

    public void warn(String message) {
        log(message, LoggerLevel.WARN);
    }

    public void error(String message) {
        log(message, LoggerLevel.ERROR);
    }

    public void fatal(String message) {
        log(message, LoggerLevel.FATAL);
    }

    public void debug(String message) {
        if (isDebug())
            log(message, LoggerLevel.DEBUG);
    }

    public void test(String message) {
        log(message, LoggerLevel.TEST);
    }

    public void info(String message, Throwable throwable) {
        info(message + "\n" + throwable.getMessage());
    }

    public void warn(String message, Throwable throwable) {
        warn(message + "\n" + throwable.getMessage());
    }

    public void error(String message, Throwable throwable) {
        error(message + "\n" + throwable.getMessage());
    }

    public void fatal(String message, Throwable throwable) {
        fatal(message + "\n" + throwable.getMessage());
    }

    public void debug(String message, Throwable throwable) {
        if (isDebug())
            debug(message + "\n" + throwable.getMessage());
    }

    public void test(String message, Throwable throwable) {
        test(message + "\n" + throwable.getMessage());
    }

}
