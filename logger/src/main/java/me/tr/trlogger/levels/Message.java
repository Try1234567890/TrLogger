
package me.tr.trlogger.levels;

import me.tr.trformatter.color.Colors;

public class Message extends Level {
    public static final Message MESSAGE = new Message();


    Message() {
        super("{MESSAGE}", Colors.ALBESCENT_WHITE);
    }

}
