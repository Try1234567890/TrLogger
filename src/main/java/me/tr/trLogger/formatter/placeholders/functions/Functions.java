package me.tr.trLogger.formatter.placeholders.functions;

import me.tr.trLogger.Utility;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.functions.list.Lower;
import me.tr.trLogger.formatter.placeholders.functions.list.Sub;
import me.tr.trLogger.formatter.placeholders.functions.list.Upper;

public enum Functions {

    SUB(Sub.class, "sub", "subString"),
    LOWER(Lower.class, "lower", "lowerCase"),
    UPPER(Upper.class, "upper", "upperCase"),
    ;

    private final Class<? extends Function> clazz;
    private final String[] ids;
    Functions(Class<? extends Function> clazz, String... ids) {
        this.clazz = clazz;
        this.ids = ids;
    }

    public String[] getIds() {
        return ids;
    }

    public Class<? extends Function> getClazz() {
        return clazz;
    }

    public static Functions fromString(String str) {
        if (Utility.isNull(str)) {
            return null;
        }
        for (Functions function : Functions.values()) {
            for (String id : function.getIds()) {
                if (id.equalsIgnoreCase(str)) {
                    return function;
                }
            }
        }
        return null;
    }
}
