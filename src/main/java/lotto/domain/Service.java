package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Map<Rank, Integer> calculateRankCount(Lottos lottos, WinningNumbers winningNumbers, Bonus bonus) {
        Map<Rank, Integer> rankCount = new HashMap<>();

        for (Lotto lotto : lottos.getUserLottos()) {
            Rank rank = lotto.match(winningNumbers, bonus);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    public double calculateRateOfReturn(Map<Rank, Integer> rankCount, Money money) {
        double totalPrizeMoney = 0;

        for (Map.Entry<Rank, Integer> entry : rankCount.entrySet()) {
            totalPrizeMoney += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return (totalPrizeMoney / money.getMoney()) * 100;
    }
}
