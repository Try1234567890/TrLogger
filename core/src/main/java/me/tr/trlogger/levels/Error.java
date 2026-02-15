
package me.tr.trlogger.levels;

import me.tr.trformatter.strings.color.Colors;

public class Error extends Level {
    public static final Error ERROR = new Error();


     Error() {
        super("{ERROR}", Colors.CORAL_RED);
    }

}
