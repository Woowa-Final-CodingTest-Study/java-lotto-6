package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Service {
    NumberGenerator generator = new NumberGenerator();
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
