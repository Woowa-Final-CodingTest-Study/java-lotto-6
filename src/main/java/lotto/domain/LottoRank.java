package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.Rank;

public class LottoRank {

    public String rankLotto(int matchingCount, boolean existBonus) {

        return Rank.assignRank(matchingCount, existBonus);
    }

    public Map<String, Integer> initializeRank() {
        Map<String, Integer> lottoRank = new HashMap<>();
        for(Rank rank : Rank.values()) {
            lottoRank.put(rank.name(), 0);
        }

        return lottoRank;
    }

}
