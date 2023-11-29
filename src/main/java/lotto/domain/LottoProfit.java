package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import lotto.constant.Rank;

public class LottoProfit {

    DecimalFormat checkUnit = new DecimalFormat("###,###.#");

    public String generateProfit(Map<String, Integer> ranking, int lottoAmount) {
        long totalPrize = Arrays.stream(Rank.values())
                .filter(rank -> ranking.containsKey(rank.name()))
                .mapToLong(rank -> (long)rank.getPrize() * ranking.get(rank.name()))
                .sum();

        return calculateProfit(totalPrize, lottoAmount*1000);
    }

    public String calculateProfit(long totalPrize, int purchaseAmount) {
        String profit = String.format("%.1f", ((double)totalPrize/purchaseAmount)*100);
        return checkUnit.format(Double.parseDouble(profit));
    }

}
