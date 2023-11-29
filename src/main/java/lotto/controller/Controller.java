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
        int ticketCount = calculateTicketCount(money);
    }

    public Money saveMoney() {
        OutputView.printMessage(REQUEST_INPUT_MONEY.getMessage());
        return InputView.requestMoneyInput();
    }

    public int calculateTicketCount(Money money) {
        int ticketCount = money.calculateTicketCount();
        return ticketCount;
    }
}
