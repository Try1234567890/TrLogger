package me.tr.trLogger.files.size;

public enum Unit {

    BYTE("B", 1),
    KILOBYTE("KiB", 1000),
    MEGABYTE("MiB", KILOBYTE.asByte() * 1000),
    GIGABYTE("GiB", MEGABYTE.asByte() * 1000),
    TERABYTE("TiB", GIGABYTE.asByte() * 1000),
    ;

    private final String symbol;
    private final long asByte;

    Unit(String symbol, long asByte) {
        this.symbol = symbol;
        this.asByte = asByte;
    }

    public String getSymbol() {
        return symbol;
    }

    public long asByte() {
        return asByte;
    }

    public static Unit fromSymbol(String symbol) {
        for (Unit unit : values()) {
            if (unit.symbol.equalsIgnoreCase(symbol)) {
                return unit;
            }
        }
        return null;
    }

}
