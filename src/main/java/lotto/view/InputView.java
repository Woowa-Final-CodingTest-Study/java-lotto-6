package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.utils.ErrorMessage;
import lotto.utils.Util;

public class InputView {
    public static Money requestMoneyInput() {
        int money = 0;
        boolean isInteger;
        do {
            String input = Console.readLine();
            money = convertToInteger(input);
            isInteger = isValidMoneyInput(money);
        } while (!isInteger);
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

    private static boolean isValidMoneyInput(int money) {
        if (money == -1) {
            return false;
        }
        return true;
    }
}


