package calculator.split;

import java.util.ArrayList;
import java.util.List;

public class NumberSplitter {

    public List<String> split(int depth, List<String> separators, String s) {
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

    public int stringToValidInt(String stringNum) {
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
}
