package me.tr.trLogger.formatter.placeholders.list.general;

import me.tr.trFiles.configuration.file.FileConfiguration;
import me.tr.trLogger.TrLogger;
import me.tr.trLogger.formatter.Formatter;
import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

public class Config extends Placeholder {

    public Config(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.CONFIG, params, functions, start, end, 1);
    }

    @Override
    public String resolve() {
        FileConfiguration config = TrLogger.getInstance().getFileLoader().getConfig();
        String path = getParams()[0].toString();
        Object value = config.get(path);
        if (value == null) {
            TrLogger.getInstance().getLogger().warn("Value not found in config at: " + path);
            return "";
        }
        return Function.apply(Formatter.getInstance().format(value.toString()), getFunctions());
    }
}
