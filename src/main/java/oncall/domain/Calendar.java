package oncall.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calendar {
    private final List<WorkDay> calendar;

    public Calendar(int startMonth, String startYoil){
        this.calendar=new ArrayList<>();
        generateCalendar(startMonth, startYoil);
    }

    private void generateCalendar(int startMonth, String startYoil){
        Month month=Month.from(startMonth);
        Yoil yoil=Yoil.from(startYoil);

        for(int i=0; i<month.getMaxDays(); i++){
            WorkDay workDay=new WorkDay(startMonth, i+1, yoil.getYoilName());
            calendar.add(workDay);

            yoil.next();
        }
    }

    public List<WorkDay> getCalendar(){
        return Collections.unmodifiableList(calendar);
    }
}
