package me.tr.trlogger.loggers;

import me.tr.trlogger.levels.TrLevel;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;

public class TrBukkitLogger extends TrLogger {

    @Override
    public void log(String msg, TrLevel level) {
        String composedMSG = compose(msg, level);
        if (hasMiniMessage()) {
            Component message = MiniMessage.miniMessage().deserialize(composedMSG);
            Bukkit.getConsoleSender().sendMessage(message);
        } else Bukkit.getConsoleSender().sendMessage(composedMSG);
    }

    /**
     * Checks if MiniMessage library is present
     * in current classpath.
     *
     * @return {@code true} if is present, otherwise {@code false}.
     */
    public static boolean hasMiniMessage() {
        try {
            Class.forName("net.kyori.adventure.text.minimessage.MiniMessage");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
