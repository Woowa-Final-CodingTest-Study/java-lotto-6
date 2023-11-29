package lotto.view;

import static lotto.contants.SystemMessage.REQUEST_BONUS_NUMBER;
import static lotto.contants.SystemMessage.REQUEST_PURCHASE_AMOUNT;
import static lotto.contants.SystemMessage.REQUEST_WINNING_NUMBER;
import static lotto.contants.Words.WINNING_RESULT;

import java.util.List;

public class OutputView {
    public static void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
    }

    public static void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBER);
    }

    public static void requestBonusNumber() {
        printEmptyLine();
        System.out.println(REQUEST_BONUS_NUMBER);
    }

    public static void printPurchaseNumber(int purchaseNumber) {
        printEmptyLine();
        System.out.println(purchaseNumber + "개를 구매했습니다.");
    }

    public static void printPurchasedLotto(List<String> purchasedLotto) {
        for (String lottoNumbers : purchasedLotto) {
            System.out.println("[" + lottoNumbers + "]");
        }
        printEmptyLine();
    }

    public static void printEmptyLine() {
        System.out.print("\n");
    }

    public static void printResult(List<String> result) {
        printEmptyLine();
        System.out.println(WINNING_RESULT);
        System.out.println("---");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void printProfitRatio(String profitRatio) {
        System.out.println("총 수익률은 " + profitRatio + "입니다.");
    }

}
