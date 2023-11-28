package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        outputView.displayLottoPurchasePrompt();
        String input = inputView.receiveInputPurchaseAmount();
        validatePurchaseUnit(input);
    }

    private void validatePurchaseUnit(String input) {
        if(Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.");
        }
    }
}
