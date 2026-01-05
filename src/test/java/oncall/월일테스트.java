package oncall;

import oncall.domain.Month;
import oncall.domain.Yoil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 월일테스트 {
    private final List<String> week = new ArrayList<>();
    private final List<String> off = new ArrayList<>();
    private final int month = 5;
    private final String day = "토";

    @Test
    void 월일테스트() {
        week.addAll(List.of("가", "나", "다", "라", "마", "바", "사"));
        off.addAll(List.of("a", "b", "c", "d", "e", "f", "g"));

        List<Integer> thisMonth = Month.valueOf(month).getDays();
        Yoil yoil=new Yoil(new ArrayList<>(List.of("월", "화", "수", "목", "금", "토", "일")));
        List<String> yoils=yoil.getYoil();
        int idx = yoils.indexOf(day);
        int weekidx=0;
        int offidx=0;

        for (Integer integer : thisMonth) {
            if(yoils.get(idx)=="토"||yoils.get(idx)=="일"){
                System.out.println(month+"월 "+integer+"일 "+yoils.get(idx)+" "+off.get(offidx));
                offidx++;
                idx++;
                if (idx > 6) idx = 0;
                if(offidx==off.size()) offidx=0;
                continue;
            }

            System.out.println(month+"월 "+integer+"일 "+yoils.get(idx)+" "+week.get(weekidx));
            weekidx++;
            idx++;

            if (idx == 6) idx = 0;
            if(offidx==off.size()) offidx=0;
            if(weekidx==week.size()) weekidx=0;
        }
    }
}