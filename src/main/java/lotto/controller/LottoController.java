package lotto.controller;

import java.util.List;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResult;
import lotto.domain.Profit;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    PurchasedLotto purchasedLotto;
    WinningLotto winningLotto;
    LottoResult lottoResult;
    int purchaseAmount;

    public void play() {
        purchaseAmount = enrollPurchaseAmount();
        int purchaseNumber = LottoPurchase.calculatePurchaseNumber(purchaseAmount);
        purchasedLotto = new PurchasedLotto(purchaseNumber);

        showPurchasedLotto(purchaseNumber);

        List<Integer> winningNumbers = enrollWinningNumbers();
        int bonusNumber = enrollBonusNumber();
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        lottoResult = new LottoResult(purchasedLotto.getWinningResult(winningLotto));
        showResult();
    }

    private int enrollPurchaseAmount() {
        OutputView.requestPurchaseAmount();
        return InputView.readPurchaseAmount();
    }

    private void showPurchasedLotto(int purchaseNumber) {
        OutputView.printPurchaseNumber(purchaseNumber);
        OutputView.printPurchasedLotto(purchasedLotto.getPurchasedLotto());
    }

    public void showResult() {
        OutputView.printResult(lottoResult.getResult());
        OutputView.printProfitRatio(Profit.getProfitRatio(lottoResult.getProfit(), purchaseAmount));
    }

    private List<Integer> enrollWinningNumbers() {
        OutputView.requestWinningNumbers();
        return InputView.readWinningNumbers();
    }

    private int enrollBonusNumber() {
        OutputView.requestBonusNumber();
        return InputView.readBonusNumber();
    }
}
