package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> userLottos;

    public Lottos (List<Lotto> numbers) {
        this.userLottos = Collections.unmodifiableList(numbers);
    }

    public List<Lotto> getUserLottos() {
        return Collections.unmodifiableList(userLottos);
    }

    public Map<Rank, Integer> calculateRankCount(WinningNumbers winningNumbers, Bonus bonus) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Lotto lotto : userLottos) {
            Rank rank = lotto.match(winningNumbers, bonus);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }
}
