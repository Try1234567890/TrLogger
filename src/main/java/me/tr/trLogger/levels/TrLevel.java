package me.tr.trlogger.levels;


import me.tr.trformatter.strings.color.TrColor;
import me.tr.trformatter.strings.color.TrColors;

public class TrLevel {
    private final String tag;
    private final TrColor color;

    public TrLevel(String tag, TrColor color) {
        this.tag = tag;
        this.color = color;
    }

    public TrLevel(String tag, TrColors color) {
        this.tag = tag;
        this.color = color.getColor();
    }

    public String getTag() {
        return tag;
    }

    public TrColor getColor() {
        return color;
    }

    public String ansi() {
        return getColor().toANSIForeground();
    }
}
