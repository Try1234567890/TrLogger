package me.tr.trlogger.levels;

import me.tr.trformatter.strings.color.Colors;

public class Info extends Level {
    public static final Info INFO = new Info();

    Info() {
        super("{INFO}", Colors.CYAN);
    }

}
