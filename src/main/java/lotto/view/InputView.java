package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static int convertStringToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력된 수는 정수여야 합니다");
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
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public static String readNumber() {
        return Console.readLine();
    }
}
