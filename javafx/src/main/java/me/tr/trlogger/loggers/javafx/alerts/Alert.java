package me.tr.trlogger.loggers.javafx.alerts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import me.tr.trformatter.strings.color.Color;

public abstract class Alert {
    private final Stage stage;
    private double xOffset = 0, yOffset = 0;

    protected Alert(String title, String message, String accentColor, Theme theme) {
        if (theme == null)
            theme = Theme.DARK;

        stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setAlwaysOnTop(true);

        VBox root = new VBox(15);
        root.setPadding(new Insets(25));
        root.setAlignment(Pos.TOP_LEFT);
        
        String bgColor = theme.bgColor().getHex("#RRGGBBAA");

        root.setStyle(
                "-fx-background-color: " + bgColor + ";" +
                        "-fx-background-radius: 12;" +
                        "-fx-border-color: " + accentColor + ";" +
                        "-fx-border-radius: 12;" +
                        "-fx-border-width: 1.5;"
        );

        double shadowOpacity = theme.shadowOpacity();

        DropShadow shadow = new DropShadow();
        shadow.setColor(javafx.scene.paint.Color.rgb(0, 0, 0, shadowOpacity));
        shadow.setRadius(20);
        shadow.setOffsetY(10);
        root.setEffect(shadow);

        Label titleLabel = new Label(title.toUpperCase());
        titleLabel.setStyle("-fx-font-family: 'Segoe UI', sans-serif; -fx-font-weight: 900; " +
                "-fx-text-fill: " + accentColor + "; -fx-font-size: 11px; -fx-letter-spacing: 1px;");

        String textColor = theme.textColor().getHex("#RRGGBBAA");

        Label messageLabel = new Label(message);
        messageLabel.setWrapText(true);
        messageLabel.setMaxWidth(350);
        messageLabel.setStyle("-fx-font-family: 'Segoe UI', sans-serif; -fx-text-fill: " + textColor + "; -fx-font-size: 14px;");

        Button closeBtn = new Button("DISMISS");
        closeBtn.setCursor(javafx.scene.Cursor.HAND);
        String btnStyle = theme == Theme.LIGHT ?
                ("-fx-background-color: " + accentColor + "; -fx-text-fill: white;") :
                ("-fx-background-color: transparent; -fx-text-fill: " + accentColor + "; -fx-border-color: " + accentColor + ";");

        closeBtn.setStyle(btnStyle + "-fx-font-weight: bold; -fx-background-radius: 5; -fx-padding: 6 15;");
        closeBtn.setOnAction(e -> stage.close());

        HBox buttonBox = new HBox(closeBtn);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        root.getChildren().addAll(titleLabel, messageLabel, buttonBox);

        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        Scene scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        stage.setScene(scene);
    }

    public Stage getStage() {
        return stage;
    }

    public void show() {
        stage.show();
    }

    public void showAndWait() {
        stage.showAndWait();
    }

    public void close() {
        stage.close();
    }

    public static InfoAlert info(String title, String msg, Theme theme) {
        return new InfoAlert(title, msg, theme);
    }

    public static InfoAlert info(String title, String msg) {
        return new InfoAlert(title, msg, Theme.DARK);
    }

    public static InfoAlert info(String msg) {
        return new InfoAlert("Information ¬", msg, Theme.DARK);
    }


    public static WarnAlert warn(String title, String msg, Theme theme) {
        return new WarnAlert(title, msg, theme);
    }

    public static WarnAlert warn(String title, String msg) {
        return new WarnAlert(title, msg, Theme.DARK);
    }

    public static WarnAlert warn(String msg) {
        return new WarnAlert("Warning ¬", msg, Theme.DARK);
    }

    public static ErrorAlert error(String title, String msg, Theme theme) {
        return new ErrorAlert(title, msg, theme);
    }

    public static ErrorAlert error(String title, String msg) {
        return new ErrorAlert(title, msg, Theme.DARK);
    }

    public static ErrorAlert error(String msg) {
        return new ErrorAlert("Error ¬", msg, Theme.DARK);
    }

    public record Theme(Color bgColor, Color textColor, double shadowOpacity) {
        public static final Theme LIGHT = new Theme(Color.ofHex("FFFFFFFF"), Color.ofHex("FF444444"), 0.15);
        public static final Theme DARK = new Theme(Color.ofHex("FF2D2D2D"), Color.ofHex("FFBBBBBB"), 0.4);

    }
}