package me.tr.trLogger.formatter.placeholders.list;

public class PlaceholderInitializationException extends RuntimeException {


    public PlaceholderInitializationException(String message) {
        super(message);
    }

    public PlaceholderInitializationException(String message, Exception e) {
        super(message, e);
    }


}
