package me.tr.trlogger.levels;


import me.tr.trformatter.strings.color.Color;
import me.tr.trformatter.strings.color.Colors;

public class TrLevel {
    private final String tag;
    private final Color color;

    public TrLevel(String tag, Color color) {
        this.tag = tag;
        this.color = color;
    }

    public TrLevel(String tag, Colors color) {
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
