package calculator;


import calculator.separator.SeparatorGetter;
import calculator.separator.SeparatorResult;
import calculator.split.NumberSplitter;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력값 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 구분자 추출
        SeparatorGetter separatorGetter = new SeparatorGetter();
        SeparatorResult separatorResult = separatorGetter.getSeparators(input);
        List<String> separators = separatorResult.getSeparators();
        String processedInput = separatorResult.getProcessedInput();

        // 문자열에서 숫자 추출
        NumberSplitter numberSplitter = new NumberSplitter();
        List<String> stringNums = numberSplitter.split(0, separators, processedInput);


        // 반환값
        int output = 0;
        for(String stringNum : stringNums) {
            output += numberSplitter.stringToValidInt(stringNum);
        }
        System.out.println("결과 : " + output);
    }
}
