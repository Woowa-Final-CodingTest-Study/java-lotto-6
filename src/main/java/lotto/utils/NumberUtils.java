package lotto.utils;

import static lotto.contants.Words.PERCENTAGE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberUtils {
    public static String formatCurrency(int currency) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(currency);
    }

    public static String formatPercentage(BigDecimal decimalNumber) {
        return decimalNumber.setScale(1, RoundingMode.HALF_UP) + PERCENTAGE;
    }
}
