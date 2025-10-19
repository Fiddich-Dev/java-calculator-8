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


        // 반환값
        int output = 0;
        System.out.println("결과 : " + output);
    }

    static boolean isValidSeparator(char redex) {
        if(redex - '0' >= 0 && redex - '0' <= 9) {
            throw new IllegalArgumentException("구분자로 숫자가 들어왔습니다.");
        }
        return true;
    }
}
