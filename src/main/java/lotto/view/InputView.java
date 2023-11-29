package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessageConstant;

public class InputView {

    private static final String REPLACEALL_REGEX = "[0-9a-zA-zㄱ-ㅎ가-힣,]";

    public int inputValue() {
        String input = Console.readLine();
        validateInputValue(input);
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinnerLottoNumbers() {
        String input = Console.readLine();
        validateInputWinnerLottoNumbers(input);
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
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

    public void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageConstant.PREFIX + ErrorMessageConstant.NULL_INPUT);
        }
    }

    public void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(ErrorMessageConstant.PREFIX + ErrorMessageConstant.CHECK_INPUT);
        }
    }

    public void validateInputCorrectSeparator(String input) {
        String deleteSeparator = input.replaceAll(REPLACEALL_REGEX, "");
        if (!deleteSeparator.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageConstant.PREFIX + ErrorMessageConstant.CHECK_SEPARATOR);
        }
    }

    public void validateWinnerNumberNumeric(String input) {
        for (String winnerLottoNumber : input.split(",")) {
            try {
                Integer.parseInt(winnerLottoNumber);
            } catch (IllegalArgumentException illegalArgumentException) {
                throw new IllegalArgumentException(ErrorMessageConstant.PREFIX + ErrorMessageConstant.CHECK_INPUT);
            }
        }
    }

}
