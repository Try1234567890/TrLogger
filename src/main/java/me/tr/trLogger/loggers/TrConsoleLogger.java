package me.tr.trlogger.loggers;

import me.tr.trformatter.TrValidator;
import me.tr.trlogger.levels.TrLevel;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.OutputStream;

public class TrConsoleLogger extends TrLogger {
    private final OutputStream out;

    public TrConsoleLogger(@NotNull OutputStream out) {
        TrValidator.isNull(out, "The output stream is null");
        this.out = out;
    }

    public TrConsoleLogger() {
        this.out = System.out;
    }

    @Override
    public void log(String msg, TrLevel level) {
        String composedMSG = compose(msg, level);
        try {
            out.write(composedMSG.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("An error occurs while writing " + composedMSG + " to the output stream.", e);
        }
    }

}
