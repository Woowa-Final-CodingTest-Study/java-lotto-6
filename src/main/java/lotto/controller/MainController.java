package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public class MainController {
    private final MoneyController moneyController;
    private final LottoController lottoController;
    private final WinningNumberController winningNumberController;
    private final BonusController bonusController;
    private final ResultController resultController;

    public MainController(MoneyController moneyController, LottoController lottoController,
                          WinningNumberController winningNumberController, BonusController bonusController,
                          ResultController resultController) {
        this.moneyController = moneyController;
        this.lottoController = lottoController;
        this.winningNumberController = winningNumberController;
        this.bonusController = bonusController;
        this.resultController = resultController;
    }

    public void init() {
        Money money = moneyController.receiveMoney();
        Lottos lottos = lottoController.generateLottos(money);
        WinningNumbers winningNumbers = winningNumberController.receiveWinningNumbers();
        Bonus bonus = bonusController.receiveBonus(winningNumbers);
        resultController.checkLottoGameResult(lottos, winningNumbers, bonus, money);
    }
}
