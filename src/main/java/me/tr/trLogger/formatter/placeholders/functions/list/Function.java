package me.tr.trLogger.formatter.placeholders.functions.list;

import me.tr.trLogger.TrLogger;
import me.tr.trLogger.Utility;
import me.tr.trLogger.formatter.placeholders.functions.FunctionInitializationException;
import me.tr.trLogger.formatter.placeholders.functions.Functions;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;
import me.tr.trLogger.logger.ConsoleLogger;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Function {
    public final static Pattern FUNCTIONS_PATTERN = Pattern.compile("(\\w+)(?:\\(([\\w,\\s]+)\\))?");
    protected ConsoleLogger logger = TrLogger.getInstance().getLogger();
    private Functions function;
    private Object[] params;

    public Function(Functions function, Object[] params) {
        this(function, params, 0);
    }

    public Function(Functions function, Object[] params, int minParams) {
        if (params.length < minParams) {
            logger.warn("Function " + this + " has less then minimum args (" + minParams + ')');
            return;
        }
        this.function = function;
        this.params = params;
    }


    public Functions getFunction() {
        return function;
    }

    public Object[] getParams() {
        return params;
    }

    public abstract String resolve(String result);


    public static String apply(String input, Function[] functions) {
        for (Function function : functions) {
            input = function.resolve(input);
        }
        return input;
    }

    /**
     * Get functions of a placeholders, format and add all to a Function array
     *
     * @param functionsToString Functions to string extracted from placeholder with {@link Placeholder#PLACEHOLDERS_PATTERN} at group(3)
     * @return Function Array with all functions if any is found, otherwise an empty array.
     */
    public static Function[] getFunctions(String functionsToString) {
        final List<Function> result = new ArrayList<>();
        if (!Utility.isNull(functionsToString)) {
            Matcher functionsMatcher = FUNCTIONS_PATTERN.matcher(functionsToString);
            while (functionsMatcher.find()) {
                String functionName = functionsMatcher.group(1);
                Functions functions = Functions.fromString(functionName);
                if (functions == null) {
                    throw new FunctionInitializationException(
                            "No function found with name: " + functionName);
                }
                Object[] params = Placeholder.getParams(functionsMatcher.group(2), ',');
                try {
                    Function function = functions.getClazz().getConstructor(Object[].class).newInstance((Object) params);
                    result.add(function);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                         NoSuchMethodException e) {
                    throw new FunctionInitializationException("Error while initialize function: " + functionName, e);
                }
            }
        }
        return result.toArray(new Function[0]);
    }

    @Override
    public String toString() {
        return "Function{function=" + function.name() + ", params=" + Arrays.toString(params) + '}';
    }
}
