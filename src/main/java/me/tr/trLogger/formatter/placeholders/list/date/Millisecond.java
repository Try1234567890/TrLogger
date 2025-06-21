package me.tr.trLogger.formatter.placeholders.list.date;

import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

public class Millisecond extends Placeholder {

    public Millisecond(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.MILLISECOND, params, functions, start, end);
    }

    @Override
    public String resolve() {
        return Function.apply(String.valueOf(System.currentTimeMillis()), getFunctions());
    }
}
