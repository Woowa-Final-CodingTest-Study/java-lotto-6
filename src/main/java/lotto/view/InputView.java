package lotto.view;


import static lotto.utils.ErrorMessage.INVALID_MONEY_NOT_INTEGER_ERROR;
import static lotto.utils.ErrorMessage.INVALID_MONEY_RANGE_ERROR;
import static lotto.utils.ErrorMessage.INVALID_MONEY_UNIT_ERROR;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.utils.ErrorMessage;
import lotto.utils.Util;

public class InputView {
    private static final int MIN_MONEY = 1000;
    private static final int MAX_MONEY = 1_000_000;
    private static final int MONEY_UNIT = 1000;

    public static Money requestMoneyInput() {
        int money = 0;
        boolean isValid;
        do {
            String input = Console.readLine();
            money = convertToInteger(input);
            isValid = validateMoney(money);
        } while (!isValid);
        return new Money(money);
    }

    private static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            OutputView.printException(ErrorMessage.INVALID_MONEY_NOT_INTEGER_ERROR.getMessage());
            return -1;
        }
    }

    private static boolean validateMoney(int money) {
        if (money == -1) {
            return false;
        }
        if (!isValidUnit(money)) {
            OutputView.printException(ErrorMessage.INVALID_MONEY_UNIT_ERROR.getMessage());
            return false;
        }
        if (!isValidRange(money)) {
            OutputView.printException(ErrorMessage.INVALID_MONEY_RANGE_ERROR.getMessage());
            return false;
        }
        return true;
    }

    private static boolean isValidUnit(int money) {
        return money % MONEY_UNIT == 0;
    }

    private static boolean isValidRange(int money) {
        return money >= MIN_MONEY && money <= MAX_MONEY;
    }
}


