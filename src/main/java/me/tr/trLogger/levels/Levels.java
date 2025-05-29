package me.tr.trLogger.levels;

import me.tr.trLogger.color.Colors;

public enum Levels {

    INFO(new TrLevel("[INFO]", Colors.WHITE.color())),
    WARN(new TrLevel("[WARN]", Colors.YELLOW.color())),
    ERROR(new TrLevel("[ERROR]", Colors.RED.color())),
    DEBUG(new TrLevel("[DEBUG]", Colors.PURPLE.color()));

    private final TrLevel level;
    Levels(TrLevel level) {
        this.level = level;
    }

    public TrLevel level() {
        return level;
    }

}
