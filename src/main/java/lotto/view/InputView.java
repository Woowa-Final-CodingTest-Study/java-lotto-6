package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.utils.ErrorMessage;

public class InputView {
    public static Money requestMoneyInput() {
        int money = -1;
        do {
            String input = Console.readLine();
            money = convertToInteger(input);
            if (money == -1) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_NOT_INTEGER_ERROR.getMessage());
            }
        } while (money == -1);
        return new Money(money);
    }

    private static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}


