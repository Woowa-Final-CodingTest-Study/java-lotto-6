package lotto.repository;

import static lotto.constant.SystemMessage.MATCH_BONUS_RESULT;
import static lotto.constant.SystemMessage.MATCH_RESULT;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.Rank;
import org.assertj.core.data.MapEntry;

public class MatchResultRepository {

    private final Map<Integer, Integer> matchResult = new HashMap<>();

    public void saveMatchResult(int rank) {
        matchResult.put(rank, matchResult.getOrDefault(rank, 0) + 1);
    }

    public StringBuilder generateMatchResult() {
        StringBuilder sb = new StringBuilder();

        for (Rank rank : Rank.values()) {
            int matchCount = rank.getMatchCount();
            int prizeAmount = rank.getPrizeAmount();
            int userMatchCount = matchResult.getOrDefault(rank.getPrize(), 0);
            if(rank.getPrize() == 2) {
                sb.append(String.format(MATCH_BONUS_RESULT.getMessage(), matchCount, prizeAmount, userMatchCount)).append("\n");
                continue;
            }
            sb.append(String.format(MATCH_RESULT.getMessage(), matchCount, prizeAmount, userMatchCount)).append("\n");
        }
        return sb;
    }

    public int generateProfit() {
        int totalPrizeAmount = 0;
        for(Integer ranking : matchResult.keySet()) {
            totalPrizeAmount += Rank.findPrizeAmount(ranking) * matchResult.get(ranking);
        }
        return totalPrizeAmount;
    }
}
