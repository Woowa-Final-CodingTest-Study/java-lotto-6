package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningLottoNumbers;

public class MainController {

    private final LottoBuyController lottoBuyController;
    private final LottoRankingController lottoRankingController;
    private final WinningNumbersController winningNumbersController;

    public MainController() {
        lottoBuyController = new LottoBuyController();
        lottoRankingController = new LottoRankingController();
        winningNumbersController = new WinningNumbersController();
    }

    public void run() {
        LottoNumbers lottoNumbers = lottoBuyController.buyLotto();
        lottoBuyController.printPurchasedLotto(lottoNumbers);

        WinningLottoNumbers winningLottoNumbers = winningNumbersController.getWinningLottoNumbers();
        lottoRankingController.printWinningStatistics(lottoNumbers, winningLottoNumbers);
    }

}
