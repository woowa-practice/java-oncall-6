package oncall.util;

import oncall.domain.Yoil;

import java.util.*;
import java.util.stream.Collectors;

public class InputValidator {
    private InputValidator(){}

    public static void validateMonthInfo(String input){
        monthInfoIsNull(input);
        invalidMonth(input);
        invalidYoil(input);
    }

    public static void validateNickname(String input){
        nicknameIsNull(input);
        List<String> names=Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        duplicateNickname(names);
    }

    public static void differentNickname(List<String> names1, List<String> names2){
        for (String s : names2) {
            if(names1.contains(s)){
                throw new IllegalArgumentException("[ERROR] 정확한 닉네임을 입력해주세요");
            }
        }
    }



    private static void monthInfoIsNull(String input){
        if(input==null){
            throw new IllegalArgumentException("[ERROR] can not null");
        }
    }

    private static void invalidMonth(String input){
        List<String> info=Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        int monthInfo=Integer.parseInt(info.get(0));
        if(monthInfo<1 || monthInfo>13){
            throw new IllegalArgumentException("[ERROR] 정확한 월을 입력해주세요");
        }
    }

    private static void invalidYoil(String input){
        List<String> yoil=new ArrayList<>(List.of("월", "화", "수", "목", "금", "토", "일"));
        List<String> info=Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        String yoilInfo=info.get(1);
        if(!yoil.contains(yoilInfo)){
            throw new IllegalArgumentException("[ERROR] 정확한 요일을 입력해주세요");
        }
    }

    private static void nicknameIsNull(String input){
        if(input==null){
            throw new IllegalArgumentException("[ERROR] can not null");
        }
    }

    private static void duplicateNickname(List<String> names){
        if(names.size()!=names.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복된 닉네임은 입력할 수 없습니다");
        }
    }
}
