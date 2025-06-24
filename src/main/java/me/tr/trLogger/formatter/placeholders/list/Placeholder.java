package me.tr.trLogger.formatter.placeholders.list;

import me.tr.trLogger.TrLogger;
import me.tr.trLogger.Utility;
import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.logger.ConsoleLogger;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Placeholder {
    public final static Pattern PLACEHOLDERS_PATTERN = Pattern.compile("\\[(\\w+)(?:\\(([^)]*)\\))?](?:\\{((?:\\w+\\([^)]*\\)[&\\s]*)+)})?");
    protected ConsoleLogger logger = TrLogger.getInstance().getLogger();
    private Placeholders placeholder;
    private Object[] params;
    private Function[] functions;
    private int start, end;

    protected Placeholder(Placeholders placeholder, Object[] params, Function[] functions, int start, int end) {
        this(placeholder, params, functions, start, end, 0);
    }

    protected Placeholder(Placeholders placeholder, Object[] params, Function[] functions, int start, int end, int minParams) {
        if (params.length < minParams) {
            logger.warn("Placeholder " + this + " has less then minimum args (" + minParams + ')');
            return;
        }
        this.placeholder = placeholder;
        this.functions = functions;
        this.params = params;
        this.start = start;
        this.end = end;
    }

    public void setPlaceholder(Placeholders placeholder) {
        this.placeholder = placeholder;
    }

    public void setFunctions(Function[] functions) {
        this.functions = functions;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Placeholders getPlaceholder() {
        return placeholder;
    }

    public Function[] getFunctions() {
        return functions;
    }

    public Object[] getParams() {
        return params;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public abstract String resolve();

    /**
     * Replace all placeholders found inside string.
     *
     * @param string String to replace placeholders into.
     * @return String with placeholders replaced
     */
    public static String apply(String string) {
        final List<Placeholder> placeholders = searchPlaceholders(string);
        placeholders.sort((p1, p2) -> Integer.compare(p2.getStart(), p1.getStart()));

        for (Placeholder placeholder : placeholders) {
            String replacement = placeholder.resolve();
            string = string.substring(0, placeholder.getStart()) +
                    replacement +
                    string.substring(placeholder.getEnd());
        }
        return string;
    }

    /**
     * Search placeholder inside a string and add to the result list.s
     *
     * @param string String to search placeholders into.
     * @return List of Placeholder if any is found, otherwise an empty list.
     * @throws IllegalArgumentException if no placeholder exists with name found.
     * @throws RuntimeException         if some error occurs while initializing the new placeholder.
     */
    public static List<Placeholder> searchPlaceholders(String string) {
        final List<Placeholder> placeholdersFound = new ArrayList<>();
        Matcher placeholdersMatcher = PLACEHOLDERS_PATTERN.matcher(string);
        while (placeholdersMatcher.find()) {
            String placeholdersName = placeholdersMatcher.group(1);
            String placeholdersParams = placeholdersMatcher.group(2);
            String placeholdersFunctions = placeholdersMatcher.group(3);
            int start = placeholdersMatcher.start();
            int end = placeholdersMatcher.end();
            Placeholders placeholders = Placeholders.fromString(placeholdersName);
            if (placeholders == null) { // Is not a placeholder
                TrLogger.getInstance().getLogger().debug("Placeholder " + placeholdersName + " not found.");
                continue;
            }
            Object[] params = getParams(placeholdersParams, ',');
            Function[] functions = Function.getFunctions(placeholdersFunctions);
            try {
                Placeholder placeholder = placeholders.getClazz().getConstructor(params.getClass(), functions.getClass(), int.class, int.class).newInstance(params, functions, start, end);
                placeholdersFound.add(placeholder);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new PlaceholderInitializationException("Error while initialize placeholder: " + placeholdersName, e);
            }
        }
        return placeholdersFound;
    }

    /**
     * Get params of placeholder or function, format and add all of it into an Object array.
     *
     * @param params    Params to string extracted from placeholder or function with {@link Placeholder#PLACEHOLDERS_PATTERN} at group(2)
     * @param separator Separator used to separate params in string.
     * @return Object array with all params if any is found, otherwise an empty Object array.
     */
    public static Object[] getParams(String params, char separator) {
        final List<Object> result = new ArrayList<>();
        if (!Utility.isNull(params)) {
            int separatorIndex = -1, nextSeparatorIndex;
            while ((separatorIndex = params.indexOf(separator, nextSeparatorIndex = separatorIndex + 1)) != -1) {
                String param = apply(params.substring(nextSeparatorIndex, separatorIndex).trim());
                result.add(param);
            }
            String param = apply(params.substring(nextSeparatorIndex).trim());
            result.add(param);
        }
        return result.toArray();
    }


    @Override
    public String toString() {
        return "Placeholder{placeholder=" + placeholder.name() + ", params=" + Arrays.toString(params) + ", functions=" + Arrays.toString(functions) + '}';
    }
}
