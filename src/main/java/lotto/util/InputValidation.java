package lotto.util;

import static lotto.constant.ErrorMessage.INPUT_AMOUNT_UNIT;
import static lotto.constant.ErrorMessage.INPUT_CORRECT_SEPARATOR;
import static lotto.constant.ErrorMessage.INPUT_DUPLICATE;
import static lotto.constant.ErrorMessage.INPUT_NULL;
import static lotto.constant.ErrorMessage.INPUT_NUMBER;
import static lotto.constant.ErrorMessage.INPUT_POSITIVE_NUMBER;
import static lotto.constant.ErrorMessage.LIMIT_LOTTO_NUMBER;
import static lotto.constant.ErrorMessage.LIMIT_PURCHASE_AMOUNT;
import static lotto.constant.NumberConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.NumberConstant.MAX_PURCHASE_AMOUNT;
import static lotto.constant.NumberConstant.MIN_LOTTO_NUMBER;
import static lotto.constant.NumberConstant.PURCHASE_UNIT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidation {

    public int validatePurchaseAmount(String input) {
        validateNull(input);
        int number = validateNumeric(input);
        validateNegative(number);
        validateUnit(number);
        validateLimit(number);

        return number;
    }

    public List<Integer> validateWinNumbers(String input) {
        validateNull(input);
        validateSeparator(input);
        validateLottoNumberNumeric(input);
        List<Integer> numbers = validateLimitLottoNumber(input);
        validateDuplicateNumbers(numbers);

        return numbers;
    }

    private void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NULL.getMessage());
        }
    }

    private int validateNumeric(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(INPUT_NUMBER.getMessage());
        }
    }

    private void validateNegative(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(INPUT_POSITIVE_NUMBER.getMessage());
        }
    }

    private void validateUnit(int input) {
        if (input % PURCHASE_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(String.format(INPUT_AMOUNT_UNIT.getMessage(), PURCHASE_UNIT.getValue()));
        }
    }

    private void validateLimit(int input) {
        if (input > MAX_PURCHASE_AMOUNT.getValue()) {
            throw new IllegalArgumentException(
                    String.format(LIMIT_PURCHASE_AMOUNT.getMessage(), MAX_PURCHASE_AMOUNT.getValue()));
        }
    }

    private void validateSeparator(String input) {
        String deleteBlank = input.replaceAll(" ", "");
        String deleteCharacters = deleteBlank.replaceAll("[0-9a-zA-Zㄱ-ㅎ가-힣,]", "");
        if (!deleteCharacters.isEmpty()) {
            throw new IllegalArgumentException(INPUT_CORRECT_SEPARATOR.getMessage());
        }
    }

    private void validateLottoNumberNumeric(String input) {
        String deleteCharacters = input.replaceAll("[0-9,]", "");
        if(!deleteCharacters.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NUMBER.getMessage());
        }
    }

    private List<Integer> validateLimitLottoNumber(String input) {
        List<String> inputNumbers = Arrays.asList(input.split(","));
        List<Integer> numbers = inputNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER.getValue() || number > MAX_LOTTO_NUMBER.getValue()) {
                throw new IllegalArgumentException(
                        String.format(LIMIT_LOTTO_NUMBER.getMessage(), MIN_LOTTO_NUMBER.getValue(),
                                MAX_LOTTO_NUMBER.getValue()));
            }
        }
        return numbers;
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for(int number : numbers) {
            if(!set.add(number)) {
                throw new IllegalArgumentException(INPUT_DUPLICATE.getMessage());
            }
        }
    }
}
