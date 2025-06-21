package me.tr.trLogger.formatter.placeholders.list.date.day;

import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

import java.time.LocalDate;

public class DayOfWeek extends Placeholder {

    public DayOfWeek(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.DAY_OF_WEEK, params, functions, start, end);
    }

    @Override
    public String resolve() {
        return Function.apply(String.valueOf(LocalDate.now().getDayOfWeek().getValue()), getFunctions());
    }
}
