package oncall.service;

import oncall.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OncallService {

    public WorkTurn oncall(int startMonth, String startYoil, Yoil yoil, Weekday weekday, DayOff dayOff) {
        List<Integer> targetMonth = loadMonth(startMonth);
        List<String> yoils = yoil.getYoil();
        WorkTurn workTurn = new WorkTurn(startMonth, startYoil);

        int yoilIdx = yoils.indexOf(startYoil);
        int weekdayIdx = 0, dayoffIdx = 0;

        for (Integer day : targetMonth) {
            if (Objects.equals(yoils.get(yoilIdx), "토") || Objects.equals(yoils.get(yoilIdx), "일")) {
                workTurn.addDayOff(dayOff.getOneDayOff(dayoffIdx));
                dayoffIdx++;
                yoilIdx++;
                if (yoilIdx > yoils.size() - 1) yoilIdx = 0;
                if (dayoffIdx == dayOff.getDayoffList().size()) dayoffIdx = 0;
                continue;
            }

            workTurn.addWeekDay(weekday.getOneWeekday(weekdayIdx));
            weekdayIdx++;
            yoilIdx++;

            if (yoilIdx > yoils.size() - 1) yoilIdx = 0;
            if (dayoffIdx == dayOff.getDayoffList().size()) dayoffIdx = 0;
            if (weekdayIdx == weekday.getWeekdayList().size()) weekdayIdx = 0;
        }

        return workTurn;
    }

    private List<Integer> loadMonth(int month) {
        return Month.valueOf(month).getDays();
    }
}
