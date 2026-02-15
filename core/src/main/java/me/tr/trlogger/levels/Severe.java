
package me.tr.trlogger.levels;


import me.tr.trformatter.strings.color.Colors;

public class Severe extends Level {
    public static final Severe SEVERE = new Severe();


    Severe() {
        super("{SEVERE}", Colors.BRICK_RED);
    }

}
