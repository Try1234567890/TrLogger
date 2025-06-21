package me.tr.trLogger.formatter.placeholders.list.date;

import me.tr.trLogger.TrLogger;
import me.tr.trLogger.files.Config;
import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Date extends Placeholder {

    public Date(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.DATE, params, functions, start, end);
    }

    @Override
    public String resolve() {
        String format = Config.DATE_FORMAT.asString();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return Function.apply(sdf.format(java.util.Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())), getFunctions());
        } catch (IllegalArgumentException e) {
            TrLogger.getInstance().getLogger().warn(e, "Error while formatting date as " + format);
            return format;
        }
    }
}
