package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.utils.ErrorMessage;

public class OutputView {

    public static void printUserLottos(Lotto lotto) {
        System.out.println(lotto);
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printWinningStatistics(Map<Rank, Integer> rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            if (rank.getCountOfMatch() > 0) {
                System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getCountOfMatch(), formatPrizeMoney(rank.getPrizeMoney()),
                        rankCount.getOrDefault(rank, 0));
            }
        }
    }

    private static String formatPrizeMoney(int prizeMoney) {
        return String.format("%,d", prizeMoney);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.2f%%입니다.\n", rateOfReturn);
    }
}
