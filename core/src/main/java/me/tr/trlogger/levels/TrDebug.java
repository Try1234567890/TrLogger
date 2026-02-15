
package me.tr.trlogger.levels;

import me.tr.trformatter.strings.color.Colors;

public class TrDebug extends TrLevel {
    public static final TrDebug DEBUG = new TrDebug();


    TrDebug() {
        super("{DEBUG}", Colors.COLD_PURPLE);
    }

}
