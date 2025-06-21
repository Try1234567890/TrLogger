package me.tr.trLogger.logger;

import me.tr.trLogger.Utility;
import me.tr.trLogger.formatter.Formatter;
import me.tr.trLogger.levels.TrLevel;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;

public class BukkitLogger extends Logger {
    @Override
    public void log(String msg, TrLevel level) {
        if (Utility.hasMiniMessage()) {
            Component component = MiniMessage.miniMessage().deserialize(Formatter.getInstance().format(level.color().minimessage() + level.prefix() + ' ' + msg));
            Bukkit.getServer().getConsoleSender().sendMessage(component);
            return;
        }
        msg = Formatter.getInstance().format(level.color().ansi() + level.prefix() + ' ' + msg);
        Bukkit.getServer().getConsoleSender().sendMessage(msg);
    }
}
