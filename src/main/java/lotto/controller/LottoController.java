package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumberGenerator;
import lotto.domain.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    LottoService lottoService = new LottoService(new NumberGenerator());

    public Lottos generateLottos(Money money) {
        int ticketCount = lottoService.convertToTicket(money);
        Lottos lottos = lottoService.generateUserLottos(ticketCount);
        OutputView.printUserLottos(lottos, ticketCount);
        return lottos;
    }
}
