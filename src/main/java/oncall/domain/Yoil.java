package oncall.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public enum Yoil {
    MON("월", 0),
    TUE("화", 1),
    WED("수", 2),
    THU("목", 3),
    FRI("금", 4),
    SAT("토", 5),
    SUN("일", 6);

    private final String yoilName;
    private final int index;

    Yoil(String yoilName, int index) {
        this.yoilName = yoilName;
        this.index = index;
    }

    //입력받은 문자열로 enum 찾기
    public static Yoil from(String name) {
        return Arrays.stream(values())
                .filter(yoil -> yoil.yoilName.equals(name))
                .findFirst()
                .orElseThrow();
    }

    //주말인지 판단
    public boolean isWeekend() {
        return this == SAT || this == SUN;
    }

    //다음 요일 구하기(월->일->월.. 순환)
    public Yoil next() {
        int idx = (this.index + 1) % 7;
        return Arrays.stream(values())
                .filter(yoil -> yoil.index == idx)
                .findFirst()
                .orElseThrow();
    }

    public String getYoilName() {
        return yoilName;
    }

    public int getIndex() {
        return index;
    }
}
