package me.tr.trlogger.levels;

import me.tr.trformatter.strings.color.Colors;

public class TrInfo extends TrLevel {
    public static final TrInfo INFO = new TrInfo();

    TrInfo() {
        super("{INFO}", Colors.CYAN);
    }

}
