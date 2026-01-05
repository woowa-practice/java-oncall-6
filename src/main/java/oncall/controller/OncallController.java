package oncall.controller;

import oncall.domain.WorkDay;
import oncall.domain.Worker;
import oncall.service.OncallService;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OncallController {
    private final InputView inputView;
    private final OutputView outputView;
    private final OncallService oncallService;

    public OncallController(InputView inputView, OutputView outputView, OncallService oncallService){
        this.inputView=inputView;
        this.outputView=outputView;
        this.oncallService=oncallService;
    }

    public void run(){
        String input=inputView.inputMonthInfo();
        List<String> monthInfo= Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        int month=Integer.parseInt(monthInfo.get(0));
        String yoil= monthInfo.get(1);

        String weekdayInput=inputView.inputWeekdayList();
        List<String> weekdayList=Arrays.stream(weekdayInput.split(","))
                .map(String::trim)
                .collect((Collectors.toList()));

        Worker weekdayWorker=new Worker(weekdayList);

        String dayoffInput=inputView.inputDayOffList();
        List<String> dayoffList=Arrays.stream(dayoffInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        Worker dayoffWorker=new Worker(dayoffList);

        List<WorkDay> result=oncallService.assign(month, yoil, weekdayWorker, dayoffWorker);

        outputView.outputAssign(result);
    }
}
