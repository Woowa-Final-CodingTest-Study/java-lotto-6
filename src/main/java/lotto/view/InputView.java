package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static int readPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> readWinningNumbers() {
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
