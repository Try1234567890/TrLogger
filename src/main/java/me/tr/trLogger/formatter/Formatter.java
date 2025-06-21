package me.tr.trLogger.formatter;

import me.tr.trLogger.formatter.placeholders.list.Placeholder;

public class Formatter {
    private static Formatter instance;

    private Formatter() {
    }

    public static Formatter getInstance() {
        if (instance == null) {
            instance = new Formatter();
        }
        return instance;
    }

    public String format(String msg) {
        return Placeholder.apply(msg);
    }
}
