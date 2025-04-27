package me.tr.trLogger;

public enum LoggerLevel {

    INFO("[INFO]", Color.MC_WHITE),
    WARN("[WARN]", Color.MC_YELLOW),
    ERROR("[ERROR]", Color.MC_RED),
    FATAL("[FATAL]", Color.MC_DARK_RED),
    DEBUG("[DEBUG]", Color.MC_PURPLE),
    TEST("[TEST]", Color.MC_DARK_BLUE);

    private final String prefix;
    private final Color color;
    LoggerLevel(String prefix, Color color) {
        this.prefix = prefix;
        this.color = color;
    }

    public String getPrefix() {
        return prefix;
    }

    public Color getColor() {
        return color;
    }
}
