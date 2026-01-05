package oncall.controller;

import oncall.domain.DayOff;
import oncall.domain.Weekday;
import oncall.domain.WorkTurn;
import oncall.domain.Yoil;
import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OncallController {
    private final InputView inputView;
    private final OutputView outputView;
    private final OncallService oncallService;

    public OncallController(InputView inputView, OutputView outputView, OncallService oncallService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.oncallService = oncallService;
    }

    public void run() {
        String monthInput = inputView.inputMonthInfo();
        List<String> monthInfo = Arrays.stream(monthInput.split(","))
                .map(String::trim)
                .toList();

        int startMonth = Integer.parseInt(monthInfo.get(0));
        String startYoil = monthInfo.get(1);

        Yoil yoil = new Yoil(new ArrayList<>(List.of("월", "화", "수", "목", "금", "토", "일")));

        String weekdayInput = inputView.inputWeekdayList();
        List<String> weekdayInfo = Arrays.stream(weekdayInput.split(","))
                .map(String::trim)
                .toList();
        Weekday weekday = new Weekday(weekdayInfo);

        String dayoffInput = inputView.inputDayOffList();
        List<String> dayoffInfo = Arrays.stream(dayoffInput.split(","))
                .map(String::trim)
                .toList();
        DayOff dayOff = new DayOff(dayoffInfo);

        WorkTurn workTurn = oncallService.oncall(startMonth, startYoil, yoil, weekday, dayOff);

        outputView.outputOncall(workTurn, yoil);
    }
}
