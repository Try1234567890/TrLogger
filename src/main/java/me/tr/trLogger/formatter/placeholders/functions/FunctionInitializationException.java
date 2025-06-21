package me.tr.trLogger.formatter.placeholders.functions;

public class FunctionInitializationException extends RuntimeException {
    public FunctionInitializationException(String message) {
        super(message);
    }

    public FunctionInitializationException(String message, Exception e) {
        super(message, e);
    }
}
