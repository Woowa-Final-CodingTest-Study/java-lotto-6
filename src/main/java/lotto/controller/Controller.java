package lotto.controller;

import static lotto.utils.GameMessage.REQUEST_INPUT_MONEY;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public void init() {
        Money money = getMoney();
    }

    public Money getMoney() {
        OutputView.printMessage(REQUEST_INPUT_MONEY.getMessage());
        return InputView.requestMoneyInput();
    }
}
