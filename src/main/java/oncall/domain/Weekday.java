package oncall.domain;

import java.util.List;

public class Weekday {
    private final List<String> weekdayList;

    public Weekday(List<String> weekdayList) {
        this.weekdayList = weekdayList;
    }

    public List<String> getWeekdayList() {
        return weekdayList;
    }
}
