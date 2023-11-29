package lotto.controller;

import static lotto.utils.GameMessage.REQUEST_INPUT_MONEY;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MoneyController {
    public Money receiveMoney() {
        Money money;
        do {
            try {
                OutputView.printMessage(REQUEST_INPUT_MONEY.getMessage());
                money = InputView.requestMoneyInput();
                return money;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
                money = null;
            }
        } while (money == null);
        return money;
    }
}
