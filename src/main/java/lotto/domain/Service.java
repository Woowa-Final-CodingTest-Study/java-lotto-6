package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

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

    public void printUserLottos(Lottos lottos, int ticketcount) {
        OutputView.printMessage(ticketcount + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getUserLottos()) {
            OutputView.printUserLottos(lotto);
        }
    }
}
