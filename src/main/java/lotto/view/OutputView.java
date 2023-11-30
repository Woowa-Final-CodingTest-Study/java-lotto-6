package lotto.view;

import static lotto.utils.GameMessage.EARNING_RATE;
import static lotto.utils.GameMessage.LINES;
import static lotto.utils.GameMessage.PRIZE_MONEY;
import static lotto.utils.GameMessage.WINNING_STATISTICS;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class OutputView {
    public static void printUserLottos(Lotto lotto) {
        System.out.println(lotto);
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printUserLottos(Lottos lottos, int ticketcount) {
        OutputView.printMessage(ticketcount + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getUserLottos()) {
            OutputView.printUserLottos(lotto);
        }
    }

    public static void printWinningStatistics(Map<Rank, Integer> rankCount) {
        printMessage("당첨 통계");
        printMessage(LINES.getMessage());
        for (Rank rank : Rank.values()) {
            if (rank.getCountOfMatch() > 0) {
                System.out.printf(WINNING_STATISTICS.getMessage(), rank.getCountOfMatch(), formatPrizeMoney(rank.getPrizeMoney()),
                        rankCount.getOrDefault(rank, 0));
            }
        }
    }

    private static String formatPrizeMoney(int prizeMoney) {
        return String.format(PRIZE_MONEY.getMessage(), prizeMoney);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(EARNING_RATE.getMessage(), rateOfReturn);
    }
}
