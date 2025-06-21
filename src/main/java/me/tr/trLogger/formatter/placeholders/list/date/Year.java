package me.tr.trLogger.formatter.placeholders.list.date;

import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

import java.time.LocalDate;

public class Year extends Placeholder {

    public Year(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.YEAR, params, functions, start, end);
    }

    @Override
    public String resolve() {
        return Function.apply(String.valueOf(LocalDate.now().getYear()), getFunctions());
    }
}
