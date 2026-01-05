package oncall.domain;

import java.util.Arrays;

public enum Holiday {
    NEWYEAR(1, 1),
    MOVEMENT(3, 1),
    CHILDREN(5, 5),
    MEMORIAL(6, 6),
    LIBERATION(8, 15),
    FOUNDATION(10, 3),
    HANGUEL(10, 9),
    CHRISTMAS(12, 5);

    private final int month;
    private final int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(int month, int day) {
        return Arrays.stream(values())
                .anyMatch(h -> h.month == month && h.day == day);
    }
}
