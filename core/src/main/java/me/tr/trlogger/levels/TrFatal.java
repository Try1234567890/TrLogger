
package me.tr.trlogger.levels;


import me.tr.trformatter.strings.color.Colors;

public class TrFatal extends TrLevel {
    public static final TrFatal FATAL = new TrFatal();


    TrFatal() {
        super("{FATAL}", Colors.FALU_RED);
    }

}
