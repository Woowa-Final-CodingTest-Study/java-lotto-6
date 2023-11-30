package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import lotto.model.Lotto;

import java.util.HashSet;
import java.util.List;

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
                int amount = parseInt(input);

                validateAmountPositive(amount);
                validateAmountDivisible(amount);

                return amount;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    public Lotto readLottoNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                List<String> strings = List.of(input.split(","));
                validateLottoLength(strings);
                List<Integer> numbers = strings.stream()
                        .map(s -> {
                            int number = parseInt(s);
                            validateLottoNumberRange(number);
                            return number;
                        }).toList();
                validateLottoUnique(numbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    public int readBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String input = Console.readLine();
                int bonusNumber = parseInt(input);
                validateLottoNumberRange(bonusNumber);
                validateBonusUnique(bonusNumber, winningLotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    private void validateAmountPositive(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_MUST_POSITIVE);
    }

    private void validateAmountDivisible(int amount) {
        if (amount % Lotto.PRICE != 0)
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_MUST_DIVISIBLE);
    }

    private void validateLottoLength(List<String> strings) {
        if (strings.size() != Lotto.LENGTH)
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INPUT_LENGTH_MUST_6);
    }

    private void validateLottoNumberRange(int number) {
        if (number < Lotto.RANGE_MIN || number > Lotto.RANGE_MAX)
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_MUST_WITHIN_RANGE);
    }

    private void validateLottoUnique(List<Integer> numbers) {
        if(numbers.size() != new HashSet<>(numbers).size())
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_MUST_NOT_DUPLICATED);
    }

    private void validateBonusUnique(int bonusNumber, Lotto winningLotto) {
        if(winningLotto.contains(bonusNumber))
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_MUST_NOT_DUPLICATED);
    }

    private int parseInt(String input) {
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
