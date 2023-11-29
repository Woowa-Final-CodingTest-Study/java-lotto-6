package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.MessageConstant;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

public class OutputView {

    public void displayLottoPurchasePrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedLottoAmount(LottoNumbers lottoNumbers) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoNumbers.getSize());
        printPurchasedLottoNumbers(lottoNumbers);
    }

    public void displayWinnerLottoNumbersPrompt() {
        System.out.println("당첨 번호를 입력해 주세요");
    }

    public void displayBonusLottoNumberPrompt() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public void printWinningStatistics(Map<String, Integer> ranking) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf(MessageConstant.STATISTICS, ranking.get("FIFTH"), ranking.get("FORTH"), ranking.get("THIRD"),
                ranking.get("SECOND"), ranking.get("FIRST"));
    }

    public void printTotalProfit(String profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    public void printPurchasedLottoNumbers(LottoNumbers lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lottoNumbers.getSize(); i++) {
            Lotto lotto = lottoNumbers.getEachLotto(i);
            sb.append("[").append(getPurchasedLottoNumbers(lotto)).append("]").append("\n");
        }

        System.out.println(sb);
    }

    public String getPurchasedLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getEachLottoNumbers();

        return String.join(", ", numbers.stream().map(String::valueOf).toArray(String[]::new));
    }
}
