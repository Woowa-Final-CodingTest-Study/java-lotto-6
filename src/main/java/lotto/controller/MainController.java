package lotto.controller;

import static lotto.constant.NumberConstant.PURCHASE_UNIT;
import static lotto.constant.SystemMessage.PURCHASE_LOTTO;

import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class MainController {

    InputService inputService = new InputService();
    LottoService lottoService = new LottoService();
    OutputView outputView = new OutputView();

    public void run() {
        int purchasePrice = inputService.getPurchaseAmount();
        generateLottoNumbers(purchasePrice);
    }

    public void generateLottoNumbers(int purchasePrice) {
        int purchaseAmount = purchasePrice / PURCHASE_UNIT.getValue();
        lottoService.generateLottoNumbers(purchaseAmount);
        outputView.print(String.format(PURCHASE_LOTTO.getMessage(), purchaseAmount));
        outputView.print(lottoService.getLottoNumbers().toString());
    }
}
