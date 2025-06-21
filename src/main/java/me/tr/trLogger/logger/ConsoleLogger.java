package me.tr.trLogger.logger;

import me.tr.trLogger.formatter.Formatter;
import me.tr.trLogger.levels.TrLevel;

public class ConsoleLogger extends Logger {
    @Override
    public void log(String msg, TrLevel level) {
        System.out.println(level.color().ansi() + Formatter.getInstance().format(level.prefix() + ' ' + msg));
    }
}
