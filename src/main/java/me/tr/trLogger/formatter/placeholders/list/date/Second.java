package me.tr.trLogger.formatter.placeholders.list.date;

import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

import java.time.LocalDateTime;

public class Second extends Placeholder {

    public Second(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.SECOND, params, functions, start, end);
    }

    @Override
    public String resolve() {
        return Function.apply(String.valueOf(LocalDateTime.now().getSecond()), getFunctions());
    }
}
