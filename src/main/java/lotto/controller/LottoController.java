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
    public void play() {
        int purchaseAmount = enrollPurchaseAmount();
        int purchaseNumber = LottoPurchase.calculatePurchaseNumber(purchaseAmount);
        PurchasedLotto purchasedLotto = new PurchasedLotto(purchaseNumber);
        Profit profit = new Profit(purchaseAmount);

        showPurchasedLotto(purchaseNumber, purchasedLotto.getPurchasedLotto());

        List<Integer> winningNumbers = enrollWinningNumbers();
        int bonusNumber = enrollBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(purchasedLotto.getWinningResult(winningLotto));
        showResult(profit, lottoResult);
    }

    private int enrollPurchaseAmount() {
        OutputView.requestPurchaseAmount();
        return InputView.readPurchaseAmount();
    }

    private void showPurchasedLotto(int purchaseNumber, List<String> purchasedLotto) {
        OutputView.printPurchaseNumber(purchaseNumber);
        OutputView.printPurchasedLotto(purchasedLotto);
    }

    private void showResult(Profit profit, LottoResult lottoResult) {
        OutputView.printResult(lottoResult.getResult());
        OutputView.printProfitRatio(profit.getProfitRatio(lottoResult.calculateProfit()));
    }

    private List<Integer> enrollWinningNumbers() {
        OutputView.requestWinningNumbers();
        return InputView.readWinningNumbers();
    }

    private int enrollBonusNumber(List<Integer> winningNumbers) {
        OutputView.requestBonusNumber();
        return InputView.readBonusNumber(winningNumbers);
    }
}
