package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public class Controller {
    MoneyController moneyController = new MoneyController();
    LottoController lottoController = new LottoController();
    WinningNumberController winningNumberController = new WinningNumberController();
    BonusController bonusController = new BonusController();
    ResultController resultController = new ResultController();

    public void init() {
        Money money = moneyController.receiveMoney();
        Lottos lottos = lottoController.generateLottos(money);
        WinningNumbers winningNumbers = winningNumberController.receiveWinningNumbers();
        Bonus bonus = bonusController.receiveBonus(winningNumbers);
        resultController.checkLottoGameResult(lottos, winningNumbers, bonus, money);
    }
}
