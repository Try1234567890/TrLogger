
package me.tr.trlogger.levels;


import me.tr.trformatter.strings.color.Colors;

public class TrSevere extends TrLevel {
    public static final TrSevere SEVERE = new TrSevere();


    TrSevere() {
        super("{SEVERE}", Colors.BRICK_RED);
    }

}
