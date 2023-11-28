package lotto.domain;

import static lotto.utils.NumberUtils.formatPercentage;

import java.math.BigDecimal;

public class Profit {
    static BigDecimal calculateProfitRatio(int profit, int purchaseAmount) {
        BigDecimal accurateProfit = BigDecimal.valueOf(profit);
        BigDecimal accuratePurchaseAmount = BigDecimal.valueOf(purchaseAmount);

        return accurateProfit.divide(accuratePurchaseAmount);
    }

    public static String getProfitRatio(int profit, int purchaseAmount) {
        BigDecimal profitRatio = calculateProfitRatio(profit, purchaseAmount).multiply(new BigDecimal(100));
        return formatPercentage(profitRatio);
    }
}
