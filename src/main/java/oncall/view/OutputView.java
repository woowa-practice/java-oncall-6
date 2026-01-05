package oncall.view;

import oncall.domain.Month;
import oncall.domain.WorkTurn;
import oncall.domain.Yoil;

import java.util.List;
import java.util.Objects;

public class OutputView {

    public void outputOncall(WorkTurn workTurn, Yoil yoil) {
        List<String> yoils = yoil.getYoil();
        List<String> weekDay = workTurn.getWeekdayTurn();
        List<String> dayOff = workTurn.getDayOffTurn();
        int weekIdx = 0;
        int offIdx = 0;

        int yoilIdx = yoils.indexOf(workTurn.getStartYoil());
        for (Object o : Month.valueOf(workTurn.getStartMonth()).getDays()) {
            if (Objects.equals(yoils.get(yoilIdx), "토") || Objects.equals(yoils.get(yoilIdx), "일")) {
                System.out.println(workTurn.getStartMonth() + "월 " + o + "일 " + yoils.get(yoilIdx) + " " + dayOff.get(offIdx));
                offIdx++;
                yoilIdx++;
                if (yoilIdx > 6) yoilIdx = 0;
                continue;
            }
            System.out.println(workTurn.getStartMonth() + "월 " + o + "일 " + yoils.get(yoilIdx) + " " + weekDay.get(weekIdx));

            weekIdx++;
            yoilIdx++;
            if (yoilIdx > 6) yoilIdx = 0;

        }
    }
}
