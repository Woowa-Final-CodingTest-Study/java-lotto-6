package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

public class MainController {

    LottoBuyController lottoBuyController = new LottoBuyController();
    WinnerNumbersController winnerNumbersController = new WinnerNumbersController();
    BonusNumberController bonusNumberController = new BonusNumberController();

    public void run() {
        LottoNumbers lottoNumbers = lottoBuyController.buyLotto();
        lottoBuyController.printPurchasedLotto(lottoNumbers);
        Lotto lotto = winnerNumbersController.receiveInputWinnerLottoNumbers();
        int bonusNumber = bonusNumberController.receiveInputBonusNumber();
    }



}
