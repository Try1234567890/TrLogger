package me.tr.trLogger.formatter.placeholders.list.file;

import me.tr.trLogger.TrLogger;
import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

import java.io.File;
import java.io.IOException;

public class CreateFile extends Placeholder {

    public CreateFile(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.CREATE_FILE, params, functions, start, end, 1);
    }

    @Override
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public String resolve() {
        File file = TrLogger.getInstance().getFiles().getFileManager().getFileFromString(getParams()[0].toString());
        boolean createDirs = getParams().length <= 1 || Boolean.parseBoolean(getParams()[1].toString());
        if (createDirs) {
            if (file.getParentFile() != null && !file.getParentFile().exists())
                file.getParentFile().mkdirs();
        }
        String replace = file.getPath();
        try {
            file.createNewFile();
        } catch (IOException e) {
            logger.warn(e, "Error while creating file " + replace);
        }
        return Function.apply(replace, getFunctions());
    }
}
