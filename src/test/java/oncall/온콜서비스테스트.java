package oncall;

import oncall.domain.WorkDay;
import oncall.domain.Worker;
import oncall.domain.Yoil;
import oncall.service.OncallService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 온콜서비스테스트 {

    private final OncallService oncallService=new OncallService();
    private static final int startMonth=5;
    private static final String startYoil="월";
    private final Worker week=new Worker(new ArrayList<>(List.of("갑","을","병","정","무","기","경","신","임","계")));
    private final Worker off=new Worker(new ArrayList<>(List.of("정","무","기","경","신","임","계","갑","을","병")));

    @Test
    void 온콜서비스테스트(){
        List<WorkDay> result=oncallService.assign(startMonth,startYoil,week,off);

        for (WorkDay day : result) {
            System.out.println(day.getMonth()+"월 "+day.getDay()+"일 "+day.getYoil().getYoilName()+" "+day.getNickname());
        }


    }
}
