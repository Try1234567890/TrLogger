package me.tr.trLogger.formatter.placeholders.list.date.month;

import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

import java.time.LocalDateTime;

public class MonthName extends Placeholder  {

    public MonthName(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.MONTH_NAME, params, functions, start, end);
    }

    @Override
    public String resolve() {
        return Function.apply(LocalDateTime.now().getMonth().name(), getFunctions());
    }
}
