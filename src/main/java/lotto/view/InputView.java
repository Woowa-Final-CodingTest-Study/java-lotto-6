package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.utils.ErrorMessage;

public class InputView {
    public static Money requestMoneyInput() {
        int money = 0;
        do {
            String input = Console.readLine();
            money = convertToInteger(input);
        } while (money == -1);
        return new Money(money);
    }

    private static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_NOT_INTEGER_ERROR.getMessage());
        }
    }
}


