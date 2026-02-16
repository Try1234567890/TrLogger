package me.tr.trlogger.levels;

import me.tr.trformatter.color.Colors;

public class Info extends Level {
    public static final Info INFO = new Info();

    Info() {
        super("{INFO}", Colors.CYAN);
    }

}
