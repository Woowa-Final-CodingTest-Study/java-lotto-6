package lotto.service;

import java.util.List;
import lotto.constant.Rank;
import lotto.repository.MatchResultRepository;

public class MatchResultService {

    MatchResultRepository matchResultRepository = new MatchResultRepository();

    public void matchNumbers(List<Integer> lottoNumbers, List<Integer> winNumbers, int bonusNumber) {
        int matchCount = 0;
        for(int winNumber : winNumbers) {
            if(lottoNumbers.contains(winNumber)) {
                matchCount++;
            }
        }
        boolean isBonus = matchBonus(lottoNumbers, bonusNumber);

        saveMatchResult(matchCount, isBonus);
    }

    public void saveMatchResult(int matchCount, boolean isBonus) {
        if(matchCount < 3) return;

        int rank = Rank.findRankByMatchCount(matchCount);

        if(matchCount == 5 && isBonus) {
            rank = Rank.findBonusPrize(matchCount);
            matchResultRepository.saveMatchResult(rank);
            return;
        }
        matchResultRepository.saveMatchResult(rank);
    }

    public boolean matchBonus(List<Integer> lottoNumbers, int bonusNumber) {
        if(lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public String getMatchResult() {
        return matchResultRepository.generateMatchResult().toString();
    }

    public int getTotalPrizeAmount() {
        return matchResultRepository.generateProfit();
    }
}
