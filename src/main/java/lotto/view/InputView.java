package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int inputValue() {
        String input = Console.readLine();
        validateInputValue(input);
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinnerLottoNumbers() {
        String input = Console.readLine();
        validateInputWinnerLottoNumbers(input);
        return Arrays.stream(input.split(","))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }

    private void validateInputValue(String input) {
        validateNull(input);
        validateNumeric(input);
    }

    private void validateInputWinnerLottoNumbers(String input) {
        validateNull(input);
        validateInputCorrectSeparator(input);
        validateWinnerNumberNumeric(input);
    }

    private void validateNull(String input) {
        if (input.isEmpty()) {
            throw new NullPointerException("[ERROR] 아무값도 입력하지 않았습니다.");
        }
    }

    public void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("[ERROR] 입력값을 확인해주세요.");
        }
    }

    private void validateInputCorrectSeparator(String input) {
        String deleteSeparator = input.replaceAll("[0-9a-zA-zㄱ-ㅎ가-힣,]", "");
        if (!deleteSeparator.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분하여 입력하세요.");
        }
    }

    private void validateWinnerNumberNumeric(String input) {
        for (String winnerLottoNumber : input.split(",")) {
            try {
                Integer.parseInt(winnerLottoNumber);
            } catch (IllegalArgumentException illegalArgumentException) {
                throw new IllegalArgumentException("[ERROR] 입력값을 확인해주세요.");
            }
        }
    }

}
