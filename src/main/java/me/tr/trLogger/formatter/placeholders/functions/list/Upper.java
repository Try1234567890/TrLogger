package me.tr.trLogger.formatter.placeholders.functions.list;

import me.tr.trLogger.Utility;
import me.tr.trLogger.formatter.placeholders.functions.Functions;

public class Upper extends Function {

    public Upper(Object[] params) {
        super(Functions.UPPER, params, 2);
    }

    @Override
    public String resolve(String result) {
        if (Utility.isNull(result)) {
            return "";
        }
        int start = Utility.getInt(getParams()[0].toString());
        int end = Utility.getInt(getParams()[1].toString());
        if ((start > result.length() || end > result.length())
                || start >= end ||
                (start == -1 || end == -1)) {
            logger.warn("Error while resolving " + this + " in " + result);
            return "";
        }
        return result.substring(0, start) + result.substring(start, end).toUpperCase() + result.substring(end);
    }
}
