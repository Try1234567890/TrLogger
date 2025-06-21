package me.tr.trLogger.formatter.placeholders.list.general;

import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

public class CurrentPath extends Placeholder {

    public CurrentPath(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.CURRENT_PATH, params, functions, start, end);
    }

    @Override
    public String resolve() {
        return Function.apply(System.getProperty("user.dir"), getFunctions());
    }
}
