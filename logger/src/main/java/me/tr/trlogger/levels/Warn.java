
package me.tr.trlogger.levels;


import me.tr.trformatter.color.Colors;

public class Warn extends Level {
    public static final Warn WARN = new Warn();


    Warn() {
        super("{WARN}", Colors.ENERGY_YELLOW);
    }

}
