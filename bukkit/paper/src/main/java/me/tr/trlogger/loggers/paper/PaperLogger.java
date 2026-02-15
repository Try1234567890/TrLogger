package me.tr.trlogger.loggers.paper;

import me.tr.trlogger.levels.Level;
import me.tr.trlogger.loggers.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class PaperLogger extends Logger {
    private final java.util.logging.Logger logger;

    public PaperLogger(Plugin plugin) {
        this.logger = plugin == null ? Bukkit.getLogger() : plugin.getLogger();
    }

    public PaperLogger() {
        this.logger = Bukkit.getLogger();
    }

    public java.util.logging.Logger getLogger() {
        return logger;
    }

    @Override
    public void log(String s, Level level) {
        getLogger().info(format(s, level));
    }
}
