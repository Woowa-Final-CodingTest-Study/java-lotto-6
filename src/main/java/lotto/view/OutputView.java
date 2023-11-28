package lotto.view;

import lotto.utils.ErrorMessage;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printException(String errorMessage) {
        System.out.println(errorMessage);
    }

}
