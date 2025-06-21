package me.tr.trLogger.files.size;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSize {
    private double amount;
    private Unit unit;

    public FileSize(double amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public long asByte() {
        return (long) (amount * unit.asByte());
    }


    public static FileSize parse(String str) {
        Pattern pattern = Pattern.compile("(\\d+)([a-zA-Z]{0,3})");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return new FileSize(Double.parseDouble(matcher.group(1)), Unit.fromSymbol(matcher.group(2)));
        } else return null;
    }
}
