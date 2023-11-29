package lotto.domain;

import static lotto.utils.NumberUtils.formatPercentage;

import java.math.BigDecimal;

public class Profit {
    int purchaseAmount;

    public Profit(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    static BigDecimal calculateProfitRatio(int profit) {
        BigDecimal accurateProfit = BigDecimal.valueOf(profit);
        BigDecimal accuratePurchaseAmount = BigDecimal.valueOf(purchaseAmount);

        return accurateProfit.divide(accuratePurchaseAmount);
    }

    public static String getProfitRatio(int profit) {
        BigDecimal profitRatio = calculateProfitRatio(profit).multiply(new BigDecimal(100));
        return formatPercentage(profitRatio);
    }
}
