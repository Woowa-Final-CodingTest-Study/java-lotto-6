package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
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

    public static WinningNumbers requestWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        do {
            String input = Console.readLine();
            winningNumbers.addAll(convertToIntegerList(input));
            if (winningNumbers.contains(-1)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NOT_INTEGER_ERROR.getMessage());
            }
        } while (winningNumbers.contains(-1));
        return new WinningNumbers(winningNumbers);
    }

    public static Bonus requestBonusInput(WinningNumbers winningNumbers) {
        int bonus = -1;
        do {
            String input = Console.readLine();
            bonus = convertToInteger(input);
            if (bonus != -1) {
                validateDuplication(winningNumbers, bonus);
            }
            if (bonus == -1) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NOT_INTEGER_ERROR.getMessage());
            }
        } while (bonus == -1);
        return new Bonus(bonus);
    }

    private static void validateDuplication(WinningNumbers winningNumbers, int bonus) {
        if (winningNumbers.getWinningNumbers().contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_ERROR.getMessage());
        }
    }


    private static List<Integer> convertToIntegerList(String input) {
        List<Integer> list = new ArrayList<>();
        try {
            String[] numberStrings = input.split(",");
            for (String numberString : numberStrings) {
                list.add(Integer.parseInt(numberString));
            }
        } catch (NumberFormatException e) {
            list.add(-1);
        }
        return list;
    }

    private static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}


