
package me.tr.trlogger.levels;

import me.tr.trformatter.strings.color.TrColors;

public class TrError extends TrLevel {
    public static final TrError ERROR = new TrError();


     TrError() {
        super("{ERROR}", TrColors.RED);
    }

}
