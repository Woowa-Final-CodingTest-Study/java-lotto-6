package lotto.controller;

import static lotto.utils.GameMessage.REQUEST_INPUT_MONEY;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Service;
import lotto.view.InputView;
import lotto.view.OutputView;


public class Controller {
    Service service = new Service();

    public void init() {
        try {
            Money money = saveMoney();
            int ticketCount = service.convertToTicket(money);
            Lottos lottos = service.generateUserLottos(ticketCount);


        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            init();
        }
    }

    public Money saveMoney() {
        OutputView.printMessage(REQUEST_INPUT_MONEY.getMessage());
        return InputView.requestMoneyInput();
    }

}
