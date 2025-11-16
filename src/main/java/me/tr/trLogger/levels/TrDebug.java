
package me.tr.trlogger.levels;

import me.tr.trformatter.strings.color.TrColors;

public class TrDebug extends TrLevel {
    public static final TrDebug DEBUG = new TrDebug();


    TrDebug() {
        super("{DEBUG}", TrColors.PURPLE);
    }

}
