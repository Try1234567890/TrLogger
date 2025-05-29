package me.tr.trLogger;

import java.io.File;

public class Utility {


    public static boolean hasMiniMessage() {
        try {
            Class.forName("net.kyori.adventure.text.minimessage.MiniMessage");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean isNull(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNull(File file) {
        return file == null || !file.exists();
    }
}
