package oncall.domain;

import java.util.List;

public class DayOff {
    private final List<String> dayoffList;

    public DayOff(List<String> dayoffList) {
        this.dayoffList = dayoffList;
    }

    public List<String> getDayoffList() {
        return dayoffList;
    }

    public String getOneDayOff(int i){
        return dayoffList.get(i);
    }
}
