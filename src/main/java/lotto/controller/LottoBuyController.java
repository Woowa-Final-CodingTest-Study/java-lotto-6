package lotto.controller;

import lotto.constant.ErrorMessageConstant;
import lotto.domain.LottoBuy;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoBuyController {

    private static final int PURCHASE_AMOUNT_UNIT = 1000;

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
            int input = inputView.inputValue();
            validatePurchaseUnit(input);
            return lottoBuy.calculateLottoAmount(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return receiveInputLottoPurchaseAmount();
        }
    }

    private void validatePurchaseUnit(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessageConstant.PREFIX +
                    ErrorMessageConstant.INPUT_PURCHASE_AMOUNT_UNIT);
        }
    }

}
