package lotto.domain;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.constant.Rank;

public class LottoProfit {

    DecimalFormat checkUnit = new DecimalFormat("###,###.#");

    public String generateProfit(Map<String, Integer> ranking, int lottoAmount) {
        long totalPrize = 0;

        for(Rank rank : Rank.values()) {
            if(ranking.get(rank.name()) != null) {
                totalPrize += rank.getPrize() * ranking.get(rank.name());
            }
        }
        return calculateProfit(totalPrize, lottoAmount*1000);
    }

    public String calculateProfit(long totalPrize, int purchaseAmount) {
        String profit = String.format("%.1f", ((double)totalPrize/purchaseAmount)*100);
        return checkUnit.format(Double.parseDouble(profit));
    }

}
