package me.tr.trLogger.formatter.placeholders;

import me.tr.trLogger.Utility;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;
import me.tr.trLogger.formatter.placeholders.list.date.*;
import me.tr.trLogger.formatter.placeholders.list.date.day.DayOfMonth;
import me.tr.trLogger.formatter.placeholders.list.date.day.DayOfWeek;
import me.tr.trLogger.formatter.placeholders.list.date.day.DayOfWeekName;
import me.tr.trLogger.formatter.placeholders.list.date.day.DayOfYear;
import me.tr.trLogger.formatter.placeholders.list.date.month.Month;
import me.tr.trLogger.formatter.placeholders.list.date.month.MonthName;
import me.tr.trLogger.formatter.placeholders.list.file.CreateFile;
import me.tr.trLogger.formatter.placeholders.list.file.DeleteFile;
import me.tr.trLogger.formatter.placeholders.list.general.Config;
import me.tr.trLogger.formatter.placeholders.list.general.CurrentPath;

public enum Placeholders {

    DATE(Date.class, "Date"),
    YEAR(Year.class, "Y", "Year"),
    MONTH(Month.class, "M", "Month"),
    MONTH_NAME(MonthName.class, "MN", "MonthName"),
    DAY_OF_MONTH(DayOfMonth.class, "DM", "DayOfMonth"),
    DAY_OF_WEEK(DayOfWeek.class, "DW", "DayOfWeek"),
    DAY_OF_WEEK_NAME(DayOfWeekName.class, "DWN", "DayOfWeekName"),
    DAY_OF_YEAR(DayOfYear.class, "DY", "DayOfYear"),
    HOUR(Hour.class, "h", "Hour"),
    MINUTE(Minute.class, "m", "Minute"),
    SECOND(Second.class, "s", "Second"),
    MILLISECOND(Millisecond.class, "m", "Millisecond"),
    CURRENT_PATH(CurrentPath.class, "CP", "CPath", "CurrentPath"),
    DELETE_FILE(DeleteFile.class, "DF", "DeleteFile"),
    CREATE_FILE(CreateFile.class, "CF", "CreateFile"),
    CONFIG(Config.class, "C", "Config", "Configuration"),
    ;

    private final String[] ids;
    private final Class<? extends Placeholder> clazz;

    Placeholders(Class<? extends Placeholder> clazz, String... ids) {
        this.clazz = clazz;
        this.ids = ids;
    }

    public String[] getIds() {
        return ids;
    }

    public Class<? extends Placeholder> getClazz() {
        return clazz;
    }

    public static Placeholders fromString(String str) {
        if (Utility.isNull(str)) {
            return null;
        }
        for (Placeholders placeholders : Placeholders.values()) {
            for (String id : placeholders.getIds()) {
                if (id.equalsIgnoreCase(str)) {
                    return placeholders;
                }
            }
        }
        return null;
    }
}
