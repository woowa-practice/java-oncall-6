package oncall.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkTurn {
    private final int startMonth;
    private final String startYoil;
    private final List<String> weekdayTurn;
    private final List<String> dayOffTurn;

    public WorkTurn(int startMonth, String startYoil){
        this.startMonth=startMonth;
        this.startYoil=startYoil;
        this.weekdayTurn=new ArrayList<>();
        this.dayOffTurn=new ArrayList<>();
    }

    public void addWeekDay(String name){
        weekdayTurn.add(name);
    }

    public void addDayOff(String name){
        dayOffTurn.add(name);
    }

    public int getStartMonth(){
        return startMonth;
    }

    public String getStartYoil(){
        return startYoil;
    }

    public List<String> getWeekdayTurn(){
        return Collections.unmodifiableList(weekdayTurn);
    }

    public List<String> getDayOffTurn(){
        return Collections.unmodifiableList(dayOffTurn);
    }
}
