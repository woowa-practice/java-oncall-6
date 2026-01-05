package oncall.domain;

public class WorkDay {
    private final int month;
    private final int day;
    private final Yoil yoil;
    private String nickname;

    public WorkDay(int month, int day, Yoil yoil) {
        this.month = month;
        this.day = day;
        this.yoil = yoil;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public Yoil getYoil() {
        return yoil;
    }

    //주말or공휴일이면 true, 평일이면 false
    public boolean isHoliday() {
        if (yoil.isWeekend()) {
            return true;
        }
        return Holiday.isHoliday(month, day);
    }
}
