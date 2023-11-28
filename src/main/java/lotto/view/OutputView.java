package lotto.view;

import java.util.List;

public class OutputView {
    public static void requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
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
        System.out.println("당첨 통계");
        System.out.println("---");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void printProfitRatio(String profitRatio) {
        System.out.println("총 수익률은 " + profitRatio + "입니다.");
    }

}
