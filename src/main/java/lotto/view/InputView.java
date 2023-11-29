package lotto.view;

import static lotto.contants.ErrorMessage.NEED_APPROPRIATE_LOTTO_LENGTH;
import static lotto.contants.ErrorMessage.NEED_APPROPRIATE_LOTTO_NUMBER_RANGE;
import static lotto.contants.ErrorMessage.NEED_INTEGER;
import static lotto.contants.ErrorMessage.NEED_LESS_THAN_MAX_WON;
import static lotto.contants.ErrorMessage.NEED_NUMBER_THAT_CAN_DIVIDE;
import static lotto.contants.ErrorMessage.NUMBER_DUPLICATED;
import static lotto.contants.Words.LOTTO_PRICE;
import static lotto.contants.Words.LOTTO_SIZE;
import static lotto.contants.Words.MAX_LOTTO_NUMBER;
import static lotto.contants.Words.MAX_PURCHASE_AMOUNT;
import static lotto.contants.Words.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int readPurchaseAmount() {
        try {
            int purchaseAmount = convertStringToInt(readNumber());
            validateAmountOverMax(purchaseAmount);
            validateAmountDivisible(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }

    public static List<Integer> readWinningNumbers() {
        try {
            List<Integer> winningNumbers = new ArrayList<>();
            String[] parsedNumbers = readNumber().split(",");
            validateWinningLength(parsedNumbers);

            for (String numberString : parsedNumbers) {
                int convertedNumber = convertStringToInt(numberString);
                validateLottoNumberRange(convertedNumber);
                validateNumberDuplication(convertedNumber, List.copyOf(winningNumbers));
                winningNumbers.add(convertedNumber);
            }
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumbers();
        }
    }

    public static int readBonusNumber(List<Integer> winningNumbers) {
        try {
            int bonusNumber = convertStringToInt(readNumber());
            validateLottoNumberRange(bonusNumber);
            validateNumberDuplication(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(winningNumbers);
        }
    }

    public static String readNumber() {
        return Console.readLine();
    }

    public static int convertStringToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NEED_INTEGER);
        }
    }

    public static void validateAmountOverMax(int purchaseAmount) {
        if (purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(NEED_LESS_THAN_MAX_WON);
        }
    }

    public static void validateAmountDivisible(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NEED_NUMBER_THAT_CAN_DIVIDE);
        }
    }

    public static void validateWinningLength(String[] winningNumbers) {
        if (winningNumbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(NEED_APPROPRIATE_LOTTO_LENGTH);
        }
    }

    public static void validateLottoNumberRange(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NEED_APPROPRIATE_LOTTO_NUMBER_RANGE);
        }
    }

    public static void validateNumberDuplication(int targetNumber, List<Integer> numbers) {
        if (numbers.contains(targetNumber)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED);
        }
    }
}
