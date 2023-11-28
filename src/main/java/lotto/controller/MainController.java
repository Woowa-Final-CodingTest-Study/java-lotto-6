package lotto.controller;

import lotto.domain.LottoNumbers;

public class MainController {

    LottoBuyController lottoBuyController = new LottoBuyController();

    public void run() {
        LottoNumbers lottoNumbers = lottoBuyController.buyLotto();
        lottoBuyController.printPurchasedLotto(lottoNumbers);
    }
}
