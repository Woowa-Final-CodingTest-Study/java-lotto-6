package lotto;

import lotto.controller.BonusController;
import lotto.controller.Controller;
import lotto.controller.LottoController;
import lotto.controller.MoneyController;
import lotto.controller.ResultController;
import lotto.controller.WinningNumberController;

public class Application {
    public static void main(String[] args) {
        MoneyController moneyController = new MoneyController();
        LottoController lottoController = new LottoController();
        WinningNumberController winningNumberController = new WinningNumberController();
        BonusController bonusController = new BonusController();
        ResultController resultController = new ResultController();

        Controller controller = new Controller(moneyController, lottoController, winningNumberController, bonusController, resultController);
        controller.init();
    }
}

