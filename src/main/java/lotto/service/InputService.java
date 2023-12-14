package lotto.service;

import static lotto.constant.SystemMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.SystemMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.constant.SystemMessage.INPUT_WIN_NUMBERS;

import java.util.List;
import lotto.util.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputService {

    InputValidation inputValidation = new InputValidation();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();


    public int getPurchaseAmount() {
        try {
            outputView.print(INPUT_PURCHASE_AMOUNT.getMessage());
            int purchaseAmount = inputView.inputPurchaseAmount();
            return purchaseAmount;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getPurchaseAmount();
        }
    }

    public List<Integer> getWinNumbers() {
        try {
            outputView.print(INPUT_WIN_NUMBERS.getMessage());
            List<Integer> winNumbers = inputView.inputWinNumbers();
            return winNumbers;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getWinNumbers();
        }
    }

    public int getBonusNumber(List<Integer> winNumbers) {
        try {
            outputView.print(INPUT_BONUS_NUMBER.getMessage());
            int bonusNumber = inputView.inputBonusNumber();
            inputValidation.validateDuplicateWithWinNumbers(bonusNumber, winNumbers);
            return bonusNumber;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getBonusNumber(winNumbers);
        }
    }
}
