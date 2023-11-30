package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.constant.ErrorMessage;

public class InputView {
    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public int readAmount() {
        while (true) {
            try {
                String input = Console.readLine();
                int amount = parseAmount(input);
                validateAmount(amount);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    private void validateAmount(int amount) {
        validateAmountPositive(amount);
        validateAmountDivisible(amount);
    }

    private void validateAmountPositive(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_MUST_POSITIVE);
    }

    private void validateAmountDivisible(int amount) {
        if (amount % Lotto.PRICE != 0)
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_MUST_DIVISIBLE);
    }

    private int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_NUMBER);
        }
    }

    private void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

}
