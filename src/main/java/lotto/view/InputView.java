package lotto.view;

import static lotto.utils.ErrorMessage.FORMAT_ERROR;
import static lotto.utils.ErrorMessage.NOT_INTEGER_ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public class InputView {
    public static Money requestMoneyInput() {
        String input = Console.readLine();
        validateMoneyInput(input);
        return new Money(Integer.parseInt(input));
    }

    public static WinningNumbers requestWinningNumbers() {
        String input = Console.readLine();
        validateWinningNumbersInput(input);
        return new WinningNumbers(convertToIntegerList(input));
    }

    public static Bonus requestBonusInput(WinningNumbers winningNumbers) {
        String input = Console.readLine();
        validateBonusInput(input);
        int bonus = Integer.parseInt(input);
        return new Bonus(winningNumbers, bonus);
    }

    public static void validateMoneyInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR.getMessage());
        }
    }

    private static void validateWinningNumbersInput(String input) {
        if (!isValidFormatForWinningNumbers(input)) {
            throw new IllegalArgumentException(FORMAT_ERROR.getMessage());
        }
    }

    private static void validateBonusInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR.getMessage());
        }
    }

    private static List<Integer> convertToIntegerList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] numberStrings = input.split(",");
        for (String numberString : numberStrings) {
            list.add(Integer.parseInt(numberString));
        }
        return list;
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static boolean isValidFormatForWinningNumbers(String input) {
        List<Integer> list = new ArrayList<>();
        try {
            String[] numberStrings = input.split(",");
            for (String numberString : numberStrings) {
                list.add(Integer.parseInt(numberString));
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


