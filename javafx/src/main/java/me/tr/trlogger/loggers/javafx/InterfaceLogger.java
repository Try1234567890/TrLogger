package me.tr.trlogger.loggers.javafx;

import javafx.scene.control.TextArea;
import me.tr.trformatter.utility.Validator;
import me.tr.trlogger.levels.Level;
import me.tr.trlogger.loggers.Logger;

public class InterfaceLogger extends Logger {
    private final TextArea out;

    /**
     * Create a new Interface Logger.
     *
     * @param out The text area to print messages to.
     * @throws NullPointerException if text area is null.
     */
    public InterfaceLogger(TextArea out) {
        Validator.isNull(out, "TextArea is null");
        this.out = out;
        setPattern("[{{TAG}}] [${#[now(format='HH:mm:ss')]#}$] {{MSG}}");
    }

    @Override
    public void log(String s, Level level) {
        if (out == null) return;
        out.appendText(s);
    }
}
