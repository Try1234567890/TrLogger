package me.tr.trLogger.formatter.placeholders.list.file;

import me.tr.trLogger.TrLogger;
import me.tr.trLogger.formatter.placeholders.Placeholders;
import me.tr.trLogger.formatter.placeholders.functions.list.Function;
import me.tr.trLogger.formatter.placeholders.list.Placeholder;

import java.io.File;

public class DeleteFile extends Placeholder {

    public DeleteFile(Object[] params, Function[] functions, int start, int end) {
        super(Placeholders.DELETE_FILE, params, functions, start, end, 1);
    }

    @Override
    public String resolve() {
        File file = TrLogger.getInstance().getFiles().getFileManager().getFileFromString(getParams()[0].toString());
        if (file.exists()) {
            if (file.delete()) {
                return Function.apply(file.getPath(), getFunctions());
            }
        }
        return Function.apply(file.getPath(), getFunctions());
    }
}
