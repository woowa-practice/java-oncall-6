package oncall.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Month {
    JAN(1, 31),
    FEB(2, 28),
    MAR(4, 31),
    APR(3, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31);

    private final int monthName;
    private final int maxDays;

    Month(int monthName, int maxDays) {
        this.monthName = monthName;
        this.maxDays = maxDays;
    }

    public static Month from(int name) {
        return Arrays.stream(values())
                .filter(month -> month.monthName == name)
                .findFirst()
                .orElseThrow();
    }

    public int getMonthName() {
        return monthName;
    }

    public int getMaxDays(){
        return maxDays;
    }
}
