package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputValidation;

public class InputView {

    InputValidation inputValidation = new InputValidation();

    public int inputPurchaseAmount() {
        String input = Console.readLine();

        return inputValidation.validatePurchaseAmount(input);
    }

    public List<Integer> inputWinNumbers() {
        String input = Console.readLine();

        return inputValidation.validateWinNumbers(input);
    }

    public int inputBonusNumber() {
        String input = Console.readLine();

        return inputValidation.validateBonusNumber(input);
    }
}
