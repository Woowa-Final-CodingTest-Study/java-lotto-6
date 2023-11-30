package lotto.domain.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumberGenerator;

public class LottoService {
    private final NumberGenerator generator;

    public LottoService(NumberGenerator generator) {
        this.generator = generator;
    }

    public int convertToTicket(Money money) {
        int ticketCount = money.calculateTicketCount();
        return ticketCount;
    }

    public Lottos generateUserLottos(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(generator.createRandomNumbers());
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
