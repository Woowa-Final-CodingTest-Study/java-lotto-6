package lotto.view;

import lotto.domain.Lotto;
import lotto.utils.ErrorMessage;

public class OutputView {

    public static void printUserLottos(Lotto lotto) {
        System.out.println(lotto);
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
