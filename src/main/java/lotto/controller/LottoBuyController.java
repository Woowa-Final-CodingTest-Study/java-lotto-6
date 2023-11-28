package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoBuy;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoBuyController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoBuy lottoBuy = new LottoBuy();

    public void printPurchasedLotto(LottoNumbers lottoNumbers) {
        outputView.printPurchasedLottoAmount(lottoNumbers);
    }

    public LottoNumbers buyLotto() {
        int lottoAmount = receiveInputLottoPurchaseAmount();
        return lottoBuy.gatherLottoNumbers(lottoAmount);
    }

    public int receiveInputLottoPurchaseAmount() {
        outputView.displayLottoPurchasePrompt();
        try {
            String input = inputView.inputPurchaseAmount();
            validatePurchaseUnit(input);
            return lottoBuy.calculateLottoAmount(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return receiveInputLottoPurchaseAmount();
        }
    }

    private void validatePurchaseUnit(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.");
        }
    }
}
