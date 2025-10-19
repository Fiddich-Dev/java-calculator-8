package calculator;


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

        // 기본 구분자 추가
        List<String> separators = new ArrayList<>();
        separators.add(Pattern.quote(","));
        separators.add(Pattern.quote(":"));
        // 커스텀 구분자 추가
        while(input.length() >= 5) {
            String custom = input.substring(0, 5);
            String front = custom.substring(0, 2);
            char redex = custom.charAt(2);
            String back = custom.substring(3);

            if(front.equals("//") && back.equals("\\n") && isValidSeparator(redex)) {
                separators.add(Pattern.quote(String.valueOf(redex)));
                input = input.substring(5);
            }
            else {
                break;
            }
        }

        List<String> stringNums = split(0, separators, input);

        // 반환값
        int output = 0;
        for(String stringNum : stringNums) {
            output += stringToValidInt(stringNum);
        }
        System.out.println("결과 : " + output);
    }

    static int stringToValidInt(String stringNum) {
        try {
            int num = Integer.parseInt(stringNum.trim());
            if(num > 0) {
                return num;
            }
            else {
                throw new IllegalArgumentException("음수가 들어옴");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 반활할 수 없는 문자가 들어옴");
        }
    }

    static boolean isValidSeparator(char redex) {
        if(redex - '0' >= 0 && redex - '0' <= 9) {
            throw new IllegalArgumentException("구분자로 숫자가 들어왔습니다.");
        }
        return true;
    }

    static List<String> split(int depth, List<String> separators, String s) {
        List<String> stringNums = new ArrayList<>();

        if(depth == separators.size()) {
            if(!s.isBlank()) {
                stringNums.add(s);
            }
            return stringNums;
        }

        String regex = separators.get(depth);
        String[] strings = s.split(regex);
        for(String string : strings) {
            stringNums.addAll(split(depth+1, separators, string));
        }

        return stringNums;
    }
}
