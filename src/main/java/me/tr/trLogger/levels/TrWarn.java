
package me.tr.trlogger.levels;

import me.tr.trformatter.strings.color.TrColors;

public class TrWarn extends TrLevel {
    public static final TrWarn WARN = new TrWarn();


    TrWarn() {
        super("{WARN}", TrColors.YELLOW);
    }

}
