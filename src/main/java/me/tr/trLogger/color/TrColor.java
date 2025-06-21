package me.tr.trLogger.color;

import me.tr.trLogger.Utility;

import java.awt.*;
import java.util.Arrays;

public class TrColor {
    private String hex;
    private String minimessage;
    private String ansi;
    private int[] rgb;
    private Color color;

    public TrColor(String hex) {
        if (!isHex(hex))
            throw new IllegalArgumentException("Hex " + hex + " is not valid");
        this.hex = hex;
        this.ansi = toAnsi(hex);
        this.rgb = toRGB(hex);
        this.color = new Color(rgb[0], rgb[1], rgb[2]);
    }

    private TrColor(int[] rgb) {
        if (!isRGB(rgb))
            throw new IllegalArgumentException("Rgb " + Arrays.toString(rgb) + " is not valid");
        this.hex = toHex(rgb);
        this.ansi = toAnsi(rgb);
        this.rgb = rgb;
        this.color = new Color(rgb[0], rgb[1], rgb[2]);
    }

    public TrColor(Color color) {
        if (color == null)
            throw new IllegalArgumentException("Color cannot be null");
        this.hex = toHex(color);
        this.ansi = toAnsi(color);
        this.rgb = toRGB(color);
        this.color = color;
    }

    // -------------- MiniMessage Separator --------------
    public String toMiniMessage(int[] rgb) {
        String hex = toHex(rgb);
        if (!isHex(hex) || !Utility.hasMiniMessage())
            return "";
        return '<' + hex + '>';
    }

    public String toMiniMessage(Color color) {
        if (color == null || !Utility.hasMiniMessage())
            return "";
        String hex = toHex(color);
        return '<' + hex + '>';
    }

    // -------------- Hex Separator --------------
    public String toHex(int[] rgb) {
        if (!isRGB(rgb))
            return "";
        return String.format("#%02X%02X%02X", rgb[0], rgb[1], rgb[2]);
    }

    public String toHex(Color color) {
        int[] rgb = new int[]{color.getRed(), color.getGreen(), color.getBlue()};
        if (!isRGB(rgb))
            return "";
        return toHex(rgb);
    }

    // -------------- Rgb Separator --------------
    public int[] toRGB(String hex) {
        if (!isHex(hex))
            return new int[]{-1, -1, -1};
        int r = Integer.parseInt(hex.substring(1, 3), 16);
        int g = Integer.parseInt(hex.substring(3, 5), 16);
        int b = Integer.parseInt(hex.substring(5, 7), 16);
        return new int[]{r, g, b};
    }

    private int[] toRGB(Color color) {
        return new int[]{color.getRed(), color.getGreen(), color.getBlue()};
    }

    // -------------- Ansi Separator --------------
    public String toAnsi(String hex) {
        int[] rgb = toRGB(hex);
        if (!isRGB(rgb))
            return "";
        return toAnsi(rgb);
    }

    public String toAnsi(int[] rgb) {
        if (!isRGB(rgb))
            return "";
        return "\u001B[38;2;" + rgb[0] + ";" + rgb[1] + ";" + rgb[2] + "m";
    }

    private String toAnsi(Color color) {
        int[] rgb = toRGB(color);
        if (!isRGB(rgb))
            return "";
        return toAnsi(rgb);
    }

    /*
        ------------ GETTERS ------------
     */

    public String hex() {
        return hex;
    }

    public String minimessage() {
        return minimessage;
    }

    public String ansi() {
        return ansi;
    }

    public int[] rgb() {
        return rgb;
    }

    public Color color() {
        return color;
    }

    /*
        ------------ SETTERS ------------
     */

    public TrColor hex(String hex) {
        this.hex = hex;
        return this;
    }

    public TrColor minimessage(String minimessage) {
        this.minimessage = minimessage;
        return this;
    }

    public TrColor ansi(String ansi) {
        this.ansi = ansi;
        return this;
    }

    public TrColor rgb(int[] rgb) {
        this.rgb = rgb;
        return this;
    }

    public TrColor color(Color color) {
        this.color = color;
        return this;
    }

    /*
        ------------ UTILITY ------------
     */
    private boolean isRGB(int[] rgb) {
        return rgb != null && rgb.length == 3 && (rgb[0] >= 0 && rgb[1] >= 0 && rgb[2] >= 0)
                && (rgb[0] <= 255 && rgb[1] <= 255 && rgb[2] <= 255);
    }

    private boolean isHex(String hex) {
        return !Utility.isNull(hex) && hex.startsWith("#") && hex.length() == 7;
    }

}
