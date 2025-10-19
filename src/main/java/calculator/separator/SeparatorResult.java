package calculator.separator;

import java.util.List;

public class SeparatorResult {

    List<String> separators;
    String processedInput;

    public SeparatorResult(List<String> separators, String processedInput) {
        this.separators = separators;
        this.processedInput = processedInput;
    }

    public List<String> getSeparators() {
        return separators;
    }

    public String getProcessedInput() {
        return processedInput;
    }
}
