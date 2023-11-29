package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static String readNumber() {
        return Console.readLine();
    }

    public static int convertStringToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력된 수는 정수여야 합니다");
        }
    }

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

    public static void validateAmountOverMax(int purchaseAmount) {
        if (purchaseAmount > 10000000) {
            throw new IllegalArgumentException("입력된 수는 1000만원 이하여야 합니다.");
        }
    }

    public static void validateAmountDivisible(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("입력된 수는 1000으로 나누어 떨어져야 합니다.");
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
                validateNumberDuplication(convertedNumber, winningNumbers);
            }
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumbers();
        }
    }

    public static void validateWinningLength(String[] winningNumbers) {
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("숫자는 6개여야 합니다");
        }
    }

    public static void validateLottoNumberRange(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("로또번호는 1~45 사이 수여야 합니다");
        }
    }

    public static void validateNumberDuplication(int targetNumber, List<Integer> numbers) {
        if (numbers.contains(targetNumber)) {
            throw new IllegalArgumentException("숫자가 중복되었습니다.");
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
}
