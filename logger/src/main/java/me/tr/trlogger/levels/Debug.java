
package me.tr.trlogger.levels;


import me.tr.trformatter.color.Colors;

public class Debug extends Level {
    public static final Debug DEBUG = new Debug();


    Debug() {
        super("{DEBUG}", Colors.COLD_PURPLE);
    }

}
