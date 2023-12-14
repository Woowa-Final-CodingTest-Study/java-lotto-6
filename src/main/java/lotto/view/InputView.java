package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidation;

public class InputView {

    InputValidation inputValidation = new InputValidation();

    public int inputPurchaseAmount() {
        String input = Console.readLine();

        return inputValidation.validatePurchaseAmount(input);
    }
}
