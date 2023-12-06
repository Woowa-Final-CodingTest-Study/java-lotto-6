package lotto.domain;

import java.util.HashMap;
import java.util.List;
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

    public void updateResult(List<Integer> numbers, WinningLottoNumbers winningLottoNumbers) {

        int matchingCount = winningLottoNumbers.matchCount(numbers);
        boolean existBonus = winningLottoNumbers.containBonusNumber(numbers);

        String rank = Rank.assignRank(matchingCount, existBonus);

        updateLottoResult(rank);
    }

    public void updateLottoResult(String rank) {
        if(!rank.equals(Rank.NOTHING.name())) {
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<String, Integer> getLottoResult() {
        return new HashMap<>(lottoResult);
    }

}
