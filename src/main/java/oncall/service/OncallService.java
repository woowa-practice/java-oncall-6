package oncall.service;

import oncall.domain.Calendar;
import oncall.domain.WorkDay;
import oncall.domain.Worker;

import java.util.List;

public class OncallService {

    public List<WorkDay> assign(int month, String yoil, Worker weekdayWorker, Worker dayoffWorker) {

        Calendar calendar = new Calendar(month, yoil);
        String previousWorker = "";
        String todayWorker = "";

        List<WorkDay> workDays = calendar.getCalendar();

        for (WorkDay workDay : workDays) {
            if (workDay.isHoliday()) {
                todayWorker = work(dayoffWorker, previousWorker);
                workDay.setNickname(todayWorker);
                previousWorker = todayWorker;
                continue;
            }
            todayWorker = work(weekdayWorker, previousWorker);
            workDay.setNickname(todayWorker);
            previousWorker = todayWorker;
        }

        return workDays;
    }

    private String work(Worker worker, String previousWorker) {
        if (worker.checkNext().equals(previousWorker)) {
            worker.swap();
        }
        String todayWorker = worker.getNextAndMove();
        return todayWorker;
    }
}
