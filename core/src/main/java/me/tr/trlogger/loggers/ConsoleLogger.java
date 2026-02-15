package me.tr.trlogger.loggers;


import me.tr.trformatter.utility.Validator;
import me.tr.trlogger.levels.Level;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleLogger extends Logger {
    private final OutputStream out;

    public ConsoleLogger(OutputStream out) {
        Validator.isNull(out, "The output stream is null");
        this.out = out;
    }

    public ConsoleLogger() {
        this.out = System.out;
    }

    @Override
    public void log(String msg, Level level) {
        String composedMSG = compose(msg, level);
        try {
            out.write(composedMSG.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("An error occurs while writing " + composedMSG + " to the output stream.", e);
        }
    }

}
