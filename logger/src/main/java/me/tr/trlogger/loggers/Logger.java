package me.tr.trlogger.loggers;

import me.tr.trformatter.TrFormatterAPI;
import me.tr.trformatter.color.ansi.ANSI;
import me.tr.trformatter.utility.Validator;
import me.tr.trlogger.levels.*;
import me.tr.trlogger.levels.Error;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;

public abstract class Logger {
    private static final Logger DEFAULT_LOGGER = new Logger() {
        @Override
        public void log(String msg, Level level) {
            System.out.println(msg);
        }
    };
    private boolean debug;
    private String pattern = "{{ANSI}}[{{TAG}}] [${#[now(format='HH:mm:ss')]#}$] {{MSG}} {{ANSI_RESET}}";

    public abstract void log(String msg, Level level);

    public void debug(String msg) {
        log(msg, Debug.DEBUG);
    }

    public void debug(Collection<String> msgs) {
        log(String.join("\n", msgs), Debug.DEBUG);
    }

    public void debug(String... msgs) {
        log(String.join("\n", msgs), Debug.DEBUG);
    }

    public void debug(Throwable t, String msg) {
        String fMsg = msg + " -- " + toStringThrowable(t);
        debug(fMsg);
    }

    public void debug(Throwable t, String... msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        debug(fMsg);
    }

    public void debug(Throwable t, Collection<String> msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        debug(fMsg);
    }

    public void debug(Throwable t) {
        debug(toStringThrowable(t));
    }

    public void error(String msg) {
        log(msg, Error.ERROR);
    }

    public void error(Collection<String> msgs) {
        log(String.join("\n", msgs), Error.ERROR);
    }

    public void error(String... msgs) {
        log(String.join("\n", msgs), Error.ERROR);
    }

    public void error(Throwable t, String msg) {
        String fMsg = msg + " -- " + toStringThrowable(t);
        error(fMsg);
    }

    public void error(Throwable t, String... msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        error(fMsg);
    }

    public void error(Throwable t, Collection<String> msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        error(fMsg);
    }

    public void error(Throwable t) {
        error(toStringThrowable(t));
    }

    public void fatal(String msg) {
        log(msg, Fatal.FATAL);
    }

    public void fatal(Collection<String> msgs) {
        log(String.join("\n", msgs), Fatal.FATAL);
    }

    public void fatal(String... msgs) {
        log(String.join("\n", msgs), Fatal.FATAL);
    }

    public void fatal(Throwable t, String msg) {
        String fMsg = msg + " -- " + toStringThrowable(t);
        fatal(fMsg);
    }

    public void fatal(Throwable t, String... msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        fatal(fMsg);
    }

    public void fatal(Throwable t, Collection<String> msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        fatal(fMsg);
    }

    public void fatal(Throwable t) {
        fatal(toStringThrowable(t));
    }

    public void info(String msg) {
        log(msg, Info.INFO);
    }

    public void info(Collection<String> msgs) {
        log(String.join("\n", msgs), Info.INFO);
    }

    public void info(String... msgs) {
        log(String.join("\n", msgs), Info.INFO);
    }

    public void info(Throwable t, String msg) {
        String fMsg = msg + " -- " + toStringThrowable(t);
        info(fMsg);
    }

    public void info(Throwable t, String... msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        info(fMsg);
    }

    public void info(Throwable t, Collection<String> msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        info(fMsg);
    }

    public void info(Throwable t) {
        info(toStringThrowable(t));
    }

    public void message(String msg) {
        log(msg, Message.MESSAGE);
    }

    public void message(Collection<String> msgs) {
        log(String.join("\n", msgs), Message.MESSAGE);
    }

    public void message(String... msgs) {
        log(String.join("\n", msgs), Message.MESSAGE);
    }

    public void message(Throwable t, String msg) {
        String fMsg = msg + " -- " + toStringThrowable(t);
        message(fMsg);
    }

    public void message(Throwable t, String... msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        message(fMsg);
    }

    public void message(Throwable t, Collection<String> msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        message(fMsg);
    }

    public void message(Throwable t) {
        message(toStringThrowable(t));
    }

    public void severe(String msg) {
        log(msg, Severe.SEVERE);
    }

    public void severe(Collection<String> msgs) {
        log(String.join("\n", msgs), Severe.SEVERE);
    }

    public void severe(String... msgs) {
        log(String.join("\n", msgs), Severe.SEVERE);
    }

    public void severe(Throwable t, String msg) {
        String fMsg = msg + " -- " + toStringThrowable(t);
        severe(fMsg);
    }

    public void severe(Throwable t, String... msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        severe(fMsg);
    }

    public void severe(Throwable t, Collection<String> msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        severe(fMsg);
    }

    public void severe(Throwable t) {
        severe(toStringThrowable(t));
    }

    public void solution(String msg) {
        log(msg, Solution.SOLUTION);
    }

    public void solution(Collection<String> msgs) {
        log(String.join("\n", msgs), Solution.SOLUTION);
    }

    public void solution(String... msgs) {
        log(String.join("\n", msgs), Solution.SOLUTION);
    }

    public void solution(Throwable t, String msg) {
        String fMsg = msg + " -- " + toStringThrowable(t);
        solution(fMsg);
    }

    public void solution(Throwable t, String... msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        solution(fMsg);
    }

    public void solution(Throwable t, Collection<String> msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        solution(fMsg);
    }

    public void solution(Throwable t) {
        solution(toStringThrowable(t));
    }

    public void warn(String msg) {
        log(msg, Warn.WARN);
    }

    public void warn(Collection<String> msgs) {
        log(String.join("\n", msgs), Warn.WARN);
    }

    public void warn(String... msgs) {
        log(String.join("\n", msgs), Warn.WARN);
    }

    public void warn(Throwable t, String msg) {
        String fMsg = msg + " -- " + toStringThrowable(t);
        warn(fMsg);
    }

    public void warn(Throwable t, String... msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        warn(fMsg);
    }

    public void warn(Throwable t, Collection<String> msgs) {
        String fMsg = String.join("\n", msgs) + " -- " + toStringThrowable(t);
        warn(fMsg);
    }

    public void warn(Throwable t) {
        warn(toStringThrowable(t));
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setPattern(String pattern) {
        if (!pattern.contains("{{MSG}}")) {
            DEFAULT_LOGGER.log("The placeholder {{MSG}} is not included in provided pattern: %s. The message provided to log is not send.", Error.ERROR);
        }
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    /**
     * Replace the placeholders in message.
     * <p>
     * <ol>
     *     <li>{@code {{ANSI}}} -> The ansi color code</li>
     *     <li>{@code {{TAG}}} -> The level tag</li>
     *     <li>{@code {{MSG}}} -> The provided message</li>
     * </ol>
     * <p>
     *
     * @param msg   The message to log.
     * @param level The level of the log.
     * @return a new formatted string.
     */
    protected String format(String msg, Level level) {
        if (Validator.isNull(msg))
            return "";
        return TrFormatterAPI.format(getPattern()
                .replace("{{ANSI}}", level.ansi())
                .replace("{{TAG}}", level.getTag())
                .replace("{{ANSI_RESET}}", ANSI.RESET_TAG)
                .replace("{{MSG}}", msg)
        );
    }

    private String toStringThrowable(Throwable t) {
        if (t == null) return "";

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
}
