package lotto.controller;

import static lotto.utils.GameMessage.REQUEST_INPUT_MONEY;

import lotto.domain.LottoManager;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    LottoManager lottoManager = new LottoManager();

    public void init() {
        Money money = saveMoney();
    }

    public Money saveMoney() {
        OutputView.printMessage(REQUEST_INPUT_MONEY.getMessage());
        return InputView.requestMoneyInput();
    }
}
