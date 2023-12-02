package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.Rank;

public class LottoResult {

    private Map<String, Integer> lottoResult;

    public LottoResult() {
        lottoResult = new HashMap<>();
        initializeResult();
    }

    public void initializeResult() {
        for(Rank rank : Rank.values()) {
            lottoResult.put(rank.name(), 0);
        }
    }

    public void updateResult(int matchingCount, boolean existBonus) {
        String rank = Rank.assignRank(matchingCount, existBonus);

        if(rank.equals(Rank.NOTHING.name())) {
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<String, Integer> getLottoResult() {
        return new HashMap<>(lottoResult);
    }

}
