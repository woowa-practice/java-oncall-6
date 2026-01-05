package oncall.view;

import oncall.domain.WorkDay;

import java.util.List;

public class OutputView {

    public void outputAssign(List<WorkDay> workDays) {
        for (WorkDay day : workDays) {
            System.out.println(day.getMonth() + "월 " + day.getDay() + "일 " + day.getYoil().getYoilName() + " " + day.getNickname());
        }
    }
}
