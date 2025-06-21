package me.tr.trLogger.formatter.placeholders.list.date.month;

import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

import java.time.LocalDateTime;

public class Month  extends Placeholder {

    public Month(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.MONTH, params, functions, start, end);
    }

    @Override
    public String resolve() {
        return Function.apply(String.valueOf(LocalDateTime.now().getMonthValue()), getFunctions());
    }
}
