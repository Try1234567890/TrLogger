package me.tr.trlogger.loggers;


import me.tr.trformatter.utility.Validator;
import me.tr.trlogger.levels.Level;

import java.io.IOException;
import java.io.OutputStream;

public class StreamLogger extends Logger {
    private final OutputStream out;

    public StreamLogger(OutputStream out) {
        Validator.isNull(out, "The output stream is null");
        this.out = out;
    }

    public StreamLogger() {
        this.out = System.out;
    }

    @Override
    public void log(String msg, Level level) {
        try {
            if (out == null) return;
            out.write(format(msg, level).getBytes());
        } catch (IOException e) {
            new IOException("An error occurs while writing " + msg + " to the output stream.", e).printStackTrace(System.err);
        }
    }

}
