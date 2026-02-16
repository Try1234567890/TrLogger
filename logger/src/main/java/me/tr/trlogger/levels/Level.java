package me.tr.trlogger.levels;


import me.tr.trformatter.color.Color;
import me.tr.trformatter.color.Colors;


public class Level {
    private final String tag;
    private final Color color;

    public Level(String tag, Color color) {
        this.tag = tag;
        this.color = color;
    }

    public Level(String tag, Colors color) {
        this.tag = tag;
        this.color = color.getColor();
    }

    public String getTag() {
        return tag;
    }

    public Color getColor() {
        return color;
    }

    public String ansi() {
        return getColor().getANSI24Bit().getTextEscapeSequence();
    }
}
