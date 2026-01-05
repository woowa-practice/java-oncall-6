package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.util.InputValidator;

public class InputView {

    public String inputMonthInfo() {
        while(true){
            try{
                System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
                String input=Console.readLine();
                InputValidator.validateMonthInfo(input);
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputWeekdayList() {
        while(true){
            try {
                System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
                String input=Console.readLine();
                InputValidator.validateNickname(input);
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputDayOffList() {
        while(true){
            try{
                System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
                String input=Console.readLine();
                InputValidator.validateNickname(input);
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
