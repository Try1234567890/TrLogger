package me.tr.trlogger.loggers.javafx;

import javafx.application.Platform;
import me.tr.trlogger.loggers.javafx.alerts.Alert;
import me.tr.trlogger.loggers.javafx.alerts.InfoAlert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest {
    @BeforeAll
    public static void initJFX() {
        try {
            Platform.startup(() -> {
                // Toolkit inizializzato
            });
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void openTest() throws InterruptedException {
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);

        Platform.runLater(() -> {
            try {
                Alert dark = new InfoAlert("title error", "an error occurs while opening this ui", Alert.Theme.DARK);
                dark.showAndWait();
                Alert light = new InfoAlert("title error", "an error occurs while opening this ui", Alert.Theme.LIGHT);
                light.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        if (!latch.await(5, TimeUnit.DAYS)) {
            throw new AssertionError("Il toolkit JavaFX non ha risposto in tempo!");
        }
    }
}
