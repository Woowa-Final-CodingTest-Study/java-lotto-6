package lotto.util;

import static lotto.constant.ErrorMessage.INPUT_AMOUNT_UNIT;
import static lotto.constant.ErrorMessage.INPUT_NULL;
import static lotto.constant.ErrorMessage.INPUT_NUMBER;
import static lotto.constant.ErrorMessage.INPUT_POSITIVE_NUMBER;
import static lotto.constant.ErrorMessage.LIMIT_PURCHASE_AMOUNT;
import static lotto.constant.NumberConstant.MAX_PURCHASE_AMOUNT;
import static lotto.constant.NumberConstant.PURCHASE_UNIT;

public class InputValidation {

    public int validatePurchaseAmount(String input) {
        validateNull(input);
        int number = validateNumeric(input);
        validateNegative(number);
        validateUnit(number);
        validateLimit(number);

        return number;
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

    private void
}
