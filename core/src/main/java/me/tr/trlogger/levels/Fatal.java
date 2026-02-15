
package me.tr.trlogger.levels;


import me.tr.trformatter.strings.color.Colors;

public class Fatal extends Level {
    public static final Fatal FATAL = new Fatal();


    Fatal() {
        super("{FATAL}", Colors.FALU_RED);
    }

}
