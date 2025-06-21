package me.tr.trLogger.formatter.placeholders.list.date;

import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

import java.time.LocalDateTime;

public class Hour extends Placeholder  {

    public Hour(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.HOUR, params, functions, start, end);
    }

    @Override
    public String resolve() {
        return Function.apply(String.valueOf(LocalDateTime.now().getHour()), getFunctions());
    }
}
