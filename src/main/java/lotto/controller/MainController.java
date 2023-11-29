package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

public class MainController {

    private final LottoBuyController lottoBuyController;
    private final LottoRankingController lottoRankingController;
    private final WinnerNumbersController winnerNumbersController;
    private final BonusNumberController bonusNumberController;

    public MainController() {
        lottoBuyController = new LottoBuyController();
        lottoRankingController = new LottoRankingController();
        winnerNumbersController = new WinnerNumbersController();
        bonusNumberController = new BonusNumberController();
    }

    public void run() {
        LottoNumbers lottoNumbers = lottoBuyController.buyLotto();
        lottoBuyController.printPurchasedLotto(lottoNumbers);

        Lotto winningLotto = winnerNumbersController.receiveInputWinnerLottoNumbers();
        int bonusNumber = bonusNumberController.receiveInputBonusNumber();
        lottoRankingController.printWinningStatistics(lottoNumbers, winningLotto, bonusNumber);
    }

}
