
package me.tr.trlogger.levels;

import me.tr.trformatter.strings.color.Colors;

public class TrError extends TrLevel {
    public static final TrError ERROR = new TrError();


     TrError() {
        super("{ERROR}", Colors.CORAL_RED);
    }

}
