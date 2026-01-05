package oncall;

import oncall.domain.DayOff;
import oncall.domain.Weekday;
import oncall.service.OncallService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 온콜서비스테스트 {

    private final OncallService oncallService=new OncallService();
    private static final int startMonth=5;
    private static final String startYoil="토";
    private final List<String> week = new ArrayList<>(List.of("가", "나", "다", "라", "마", "바", "사"));
    private final List<String> off = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g"));

    @Test
    void 온콜서비스테스트(){
        Weekday weekday=new Weekday(week);
        DayOff dayOff=new DayOff(off);

        System.out.println(oncallService.oncall(startMonth, startYoil, weekday, dayOff).getWeekdayTurn());
        System.out.println(oncallService.oncall(startMonth, startYoil, weekday, dayOff).getDayOffTurn());
    }
}
