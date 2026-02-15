
package me.tr.trlogger.levels;


import me.tr.trformatter.strings.color.Colors;

public class TrSolution extends TrLevel {
    public static final TrSolution SOLUTION = new TrSolution();


    TrSolution() {
        super("{SOLUTION}", Colors.GREEN_YELLOW);
    }

}
