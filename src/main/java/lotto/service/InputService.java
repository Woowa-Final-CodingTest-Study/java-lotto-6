package lotto.service;

import static lotto.constant.SystemMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.constant.SystemMessage.INPUT_WIN_NUMBERS;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputService {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();


    public int getPurchaseAmount() {
        try {
            outputView.print(INPUT_PURCHASE_AMOUNT.getMessage());
            int purchaseAmount = inputView.inputPurchaseAmount();
            return purchaseAmount;
        } catch(IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getPurchaseAmount();
        }
    }

    public List<Integer> getWinNumbers() {
        try {
            outputView.print(INPUT_WIN_NUMBERS.getMessage());
            List<Integer> winNumbers = inputView.inputWinNumbers();
            return winNumbers;
        } catch(IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getWinNumbers();
        }
    }
}
