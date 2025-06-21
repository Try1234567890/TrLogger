package me.tr.trLogger.files;

import me.tr.trFiles.configuration.file.FileConfiguration;
import me.tr.trLogger.TrLogger;

public enum Config {

    DEBUG("Debug", false),


    CHAR_PLACEHOLDERS_START("Chars.Placeholders.Start", '['),
    CHAR_PLACEHOLDERS_END("Chars.Placeholders.End", ']'),
    CHAR_PLACEHOLDERS_PARAMS_START("Chars.Placeholders.Params.Start", '('),
    CHAR_PLACEHOLDERS_PARAMS_END("Chars.Placeholders.Params.End", ')'),
    CHAR_PLACEHOLDERS_PARAMS_SPLIT("Chars.Placeholders.Params.Split", ','),

    CHAR_FUNCTIONS_START("Chars.Functions.Start", '{'),
    CHAR_FUNCTIONS_END("Chars.Functions.End", '}'),
    CHAR_FUNCTIONS_PARAMS_START("Chars.Functions.Params.Start", '('),
    CHAR_FUNCTIONS_PARAMS_END("Chars.Functions.Params.End", ')'),
    CHAR_FUNCTIONS_PARAMS_SPLIT("Chars.Functions.Params.Split", ','),
    CHAR_FUNCTIONS_SPLIT("Chars.Functions.Split", '&'),

    DATE_FORMAT("Date.Format", "yyyy-MM-dd HH:mm:ss"),
    FILE_NAME("Loggers.File.Name", "log-[date].txt"),
    FILE_PATH("Loggers.File.Path", "[CP]/logs/[Config(Loggers.File.Name)].txt"),
    FILE_MAX_SIZE("Loggers.File.MaxSize", "128Mib"),
    AT_MAX_SIZE_MOVE_TO("Loggers.File.AtMaxSizeMoveTo", "[CP]/logs/backups/"),
    BACKUP_ENABLE("Loggers.File.Backup.Enable", false),
    BACKUP_TYPE("Loggers.File.Backup.Type", "Size"),
    BACKUP_SIZE("Loggers.File.Backup.Size", "128Mib"),
    BACKUP_TIME("Loggers.File.Backup.Time", "12h"),
    BACKUP_PATH("Loggers.File.Backup.Path", "[CP]/logs/backups/[Config(Loggers.File.Name)].zip"),
    ;
    private final FileConfiguration config = TrLogger.getInstance().getFileLoader().getConfig();
    private final String path;
    private final Object def;

    Config(String path, Object def) {
        this.path = path;
        this.def = def;
    }

    public String path() {
        return path;
    }

    public Object def() {
        return def;
    }

    public String asString() {
        if (config == null) {
            return (String) def;
        }
        return config.getString(path, (String) def);
    }

    public char asChar() {
        if (config == null) {
            return (char) def;
        }
        return config.getChar(path, (char) def);
    }

    public boolean asBoolean() {
        if (config == null) {
            return (boolean) def;
        }
        return config.getBoolean(path, (boolean) def);
    }
}
