package lotto.model;

import java.util.HashMap;
import java.util.List;

public class WinningManager {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningManager(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult getResult(int amount, LottoBundle lottoBundle) {
        HashMap<LottoRank, Long> counts = new HashMap<>();
        int prizeSum = 0;
        List<LottoRank> ranks = lottoBundle.ranks(winningLotto, bonusNumber);
        for (LottoRank rank : LottoRank.values()) {
            long count = ranks.stream()
                    .filter(r -> r == rank)
                    .count();
            counts.put(rank, count);
            prizeSum += count * rank.prize;
        }
        return new WinningResult(counts, (float)prizeSum/amount);
    }
}
