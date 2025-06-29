package me.tr.trLogger.levels;

import me.tr.trLogger.color.TrColors;

public enum TrLevels {

    INFO(new TrLevel("{INFO}", TrColors.WHITE.color())),
    WARN(new TrLevel("{WARN}", TrColors.YELLOW.color())),
    ERROR(new TrLevel("{ERROR}", TrColors.RED.color())),
    DEBUG(new TrLevel("{DEBUG}", TrColors.PURPLE.color()));

    private final TrLevel level;
    TrLevels(TrLevel level) {
        this.level = level;
    }

    public TrLevel level() {
        return level;
    }

}
