package oncall.domain;

public class WorkDay {
    private final int month;
    private final int day;
    private final String yoil;

    public WorkDay(int month, int day, String yoil) {
        this.month = month;
        this.day = day;
        this.yoil = yoil;
    }

    //주말or공휴일이면 true, 평일이면 false
    public boolean isHoliday() {
        if (yoil.equals("토") || yoil.equals("일")) {
            return true;
        }
        return Holiday.isHoliday(month, day);
    }
}
