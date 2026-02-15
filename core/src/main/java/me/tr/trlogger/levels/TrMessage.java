
package me.tr.trlogger.levels;

import me.tr.trformatter.strings.color.Colors;

public class TrMessage extends TrLevel {
    public static final TrMessage MESSAGE = new TrMessage();


    TrMessage() {
        super("{MESSAGE}", Colors.ALBESCENT_WHITE);
    }

}
