package me.tr.trLogger.levels;

import me.tr.trLogger.color.TrColor;

public class TrLevel {
    private String prefix;
    private TrColor color;

    public TrLevel(String prefix, TrColor color) {
        this.prefix = prefix;
        this.color = color;
    }

    public String prefix() {
        return prefix;
    }

    public TrLevel prefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public TrColor color() {
        return color;
    }

    public TrLevel color(TrColor color) {
        this.color = color;
        return this;
    }
}
