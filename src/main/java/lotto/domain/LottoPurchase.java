package lotto.domain;

import static lotto.contants.Words.LOTTO_PRICE;

public class LottoPurchase {
    public static int calculatePurchaseNumber(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
