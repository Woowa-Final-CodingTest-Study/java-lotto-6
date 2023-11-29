package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<WinningMatch, Integer> matchResult = new HashMap<>();

    public LottoResult(List<WinningMatch> winningMatches) {
        for (WinningMatch winningMatch : winningMatches) {
            if (matchResult.containsKey(winningMatch)) {
                matchResult.replace(winningMatch, matchResult.get(winningMatch) + 1);
            }
            matchResult.put(winningMatch, 1);
        }
    }

    public List<String> getResult() {
        List<String> result = new ArrayList<>();
        for (WinningMatch winningMatch : WinningMatch.values()) {
            int number = 0;
            String match = winningMatch.getWinningMatchString(winningMatch);
            match += (" - ");
            if (matchResult.containsKey(winningMatch)) {
                number = matchResult.get(winningMatch);
            }
            match += number + "개";
            result.add(match);
        }
        return result;
    }

    public int calculateProfit() {
        int result = 0;
        for (WinningMatch key : matchResult.keySet()) {
            result += key.getPrizeMoney() * matchResult.get(key);
        }
        return result;
    }

}
