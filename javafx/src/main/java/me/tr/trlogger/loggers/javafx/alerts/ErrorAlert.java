package me.tr.trlogger.loggers.javafx.alerts;

public class ErrorAlert extends Alert {
    public ErrorAlert(String title, String message, Theme theme) {
        super(title, message, "#FF5555", theme);
    }
}
