package me.tr.trLogger;

public enum Color {
    // Minecraft Colors
    MC_BLACK("Black", "#000000", '0', 0, 0, 0),
    MC_DARK_BLUE("Dark Blue", "#0000AA", '1', 0, 0, 170),
    MC_DARK_GREEN("Dark Green", "#00AA00", '2', 0, 170, 0),
    MC_DARK_AQUA("Dark Aqua", "#00AAAA", '3', 0, 170, 170),
    MC_DARK_RED("Dark Red", "#AA0000", '4', 170, 0, 0),
    MC_PURPLE("Purple", "#AA00AA", '5', 170, 0, 170),
    MC_GOLD("Gold", "#FFAA00", '6', 255, 170, 0),
    MC_GRAY("Gray", "#AAAAAA", '7', 170, 170, 170),
    MC_DARK_GRAY("Dark Gray", "#555555", '8', 85, 85, 85),
    MC_BLUE("Blue", "#5555FF", '9', 85, 85, 255),
    MC_GREEN("Green", "#55FF55", 'a', 85, 255, 85),
    MC_AQUA("Aqua", "#55FFFF", 'b', 85, 255, 255),
    MC_RED("Red", "#FF5555", 'c', 255, 85, 85),
    MC_LIGHT_PURPLE("Light Purple", "#FF55FF", 'd', 255, 85, 255),
    MC_YELLOW("Yellow", "#FFFF55", 'e', 255, 255, 85),
    MC_WHITE("White", "#FFFFFF", 'f', 255, 255, 255),

    // Minecraft Tags
    BOLD("Bold", "bold", 'l', 0, 0, 0),
    ITALIC("Italic", "italic", 'o', 0, 0, 0),
    UNDERLINE("Underline", "underline", 'n', 0, 0, 0),
    STRIKETHROUGH("Strike Through", "strikethrough", 'm', 0, 0, 0),
    RESET("Reset", "reset", 'r', 0, 0, 0),

    // Additional Colors
    ALICE_BLUE("Alice Blue", "#F0F8FF", 240, 248, 255),
    ANTIQUE_WHITE("Antique White", "#FAEBD7", 250, 235, 215),
    AQUA("Aqua", "#00FFFF", 0, 255, 255),
    AQUAMARINE("Aquamarine", "#7FFFD4", 127, 255, 212),
    AZURE("Azure", "#F0FFFF", 240, 255, 255),
    BEIGE("Beige", "#F5F5DC", 245, 245, 220),
    BISQUE("Bisque", "#FFE4C4", 255, 228, 196),
    BLANCHED_ALMOND("Blanched Almond", "#FFEBCD", 255, 235, 205),
    BLUE("Blue", "#0000FF", 0, 0, 255),
    BLUE_VIOLET("Blue Violet", "#8A2BE2", 138, 43, 226),
    BROWN("Brown", "#A52A2A", 165, 42, 42),
    BURLY_WOOD("Burly Wood", "#DEB887", 222, 184, 135),
    CADET_BLUE("Cadet Blue", "#5F9EA0", 95, 158, 160),
    CHARTREUSE("Chartreuse", "#7FFF00", 127, 255, 0),
    CHOCOLATE("Chocolate", "#D2691E", 210, 105, 30),
    CORAL("Coral", "#FF7F50", 255, 127, 80),
    CORNFLOWER_BLUE("Cornflower Blue", "#6495ED", 100, 149, 237),
    CORNSILK("Cornsilk", "#FFF8DC", 255, 248, 220),
    CRIMSON("Crimson", "#DC143C", 220, 20, 60),
    CYAN("Cyan", "#00FFFF", 0, 255, 255),
    DARK_BLUE("Dark Blue", "#00008B", 0, 0, 139),
    DARK_CYAN("Dark Cyan", "#008B8B", 0, 139, 139),
    DARK_GOLDEN_ROD("Dark Golden Rod", "#B8860B", 184, 134, 11),
    DARK_GRAY("Dark Gray", "#A9A9A9", 169, 169, 169),
    DARK_GREEN("Dark Green", "#006400", 0, 100, 0),
    DARK_KHAKI("Dark Khaki", "#BDB76B", 189, 183, 107),
    DARK_MAGENTA("Dark Magenta", "#8B008B", 139, 0, 139),
    DARK_OLIVE_GREEN("Dark Olive Green", "#556B2F", 85, 107, 47),
    DARK_ORANGE("Dark Orange", "#FF8C00", 255, 140, 0),
    DARK_ORCHID("Dark Orchid", "#9932CC", 153, 50, 204),
    DARK_RED("Dark Red", "#8B0000", 139, 0, 0),
    DARK_SALMON("Dark Salmon", "#E9967A", 233, 150, 122),
    DARK_SEA_GREEN("Dark Sea Green", "#8FBC8F", 143, 188, 143),
    DARK_SLATE_BLUE("Dark Slate Blue", "#483D8B", 72, 61, 139),
    DARK_SLATE_GRAY("Dark Slate Gray", "#2F4F4F", 47, 79, 79),
    DARK_TURQUOISE("Dark Turquoise", "#00CED1", 0, 206, 209),
    DARK_VIOLET("Dark Violet", "#9400D3", 148, 0, 211),
    DEEP_PINK("Deep Pink", "#FF1493", 255, 20, 147),
    DEEP_SKY_BLUE("Deep Sky Blue", "#00BFFF", 0, 191, 255),
    DIM_GRAY("Dim Gray", "#696969", 105, 105, 105),
    DODGER_BLUE("Dodger Blue", "#1E90FF", 30, 144, 255),
    FIREBRICK("Firebrick", "#B22222", 178, 34, 34),
    FLORAL_WHITE("Floral White", "#FFFAF0", 255, 250, 240),
    FOREST_GREEN("Forest Green", "#228B22", 34, 139, 34),
    FUCHSIA("Fuchsia", "#FF00FF", 255, 0, 255),
    GAINSBORO("Gainsboro", "#DCDCDC", 220, 220, 220),
    GHOST_WHITE("Ghost White", "#F8F8FF", 248, 248, 255),
    GOLD("Gold", "#FFD700", 255, 215, 0),
    GOLDEN_ROD("Golden Rod", "#DAA520", 218, 165, 32),
    GRAY("Gray", "#808080", 128, 128, 128),
    GREEN_YELLOW("Green Yellow", "#ADFF2F", 173, 255, 47),
    HONEYDEW("Honeydew", "#F0FFF0", 240, 255, 240),
    HOT_PINK("Hot Pink", "#FF69B4", 255, 105, 180);

    private final String name;
    private final String hexCode;
    private char charCode = 'b';
    private final int red;
    private final int green;
    private final int blue;

    Color(String name, String hexCode, char charCode, int red, int green, int blue) {
        this.name = name;
        this.hexCode = hexCode;
        this.charCode = charCode;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    Color(String name, String hexCode, int red, int green, int blue) {
        this.name = name;
        this.hexCode = hexCode;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public String getName() {
        return name;
    }

    public String getHexCode() {
        return hexCode;
    }

    public char getCharCode() {
        return charCode;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getRGB() {
        return getRed() + ";" + getGreen() + ";" + getBlue();
    }

    public String toWinTerminalTag() {
        return "\u001B[38;" + getRGB() + ";0m\u001B[0m";
    }
}
