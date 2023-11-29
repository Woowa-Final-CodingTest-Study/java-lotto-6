package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.MessageConstant;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

public class OutputView {

    public void displayLottoPurchasePrompt() {
        System.out.println(MessageConstant.INPUT_PURCHASE_AMOUNT);
    }

    public void printPurchasedLottoAmount(LottoNumbers lottoNumbers) {
        System.out.printf(MessageConstant.PURCHASED_LOTTO_AMOUNT, lottoNumbers.getSize());
        printPurchasedLottoNumbers(lottoNumbers);
    }

    public void displayWinnerLottoNumbersPrompt() {
        System.out.println(MessageConstant.INPUT_WINNING_NUMBERS);
    }

    public void displayBonusLottoNumberPrompt() {
        System.out.println();
        System.out.println(MessageConstant.INPUT_BONUS_NUMBER);
    }

    public void printWinningStatistics(Map<String, Integer> ranking) {
        System.out.printf(MessageConstant.STATISTICS, ranking.get(Rank.FIFTH.name()), ranking.get(Rank.FORTH.name()),
                ranking.get(Rank.THIRD.name()), ranking.get(Rank.SECOND.name()), ranking.get(Rank.FIRST.name()));
    }

    public void printTotalProfit(String profit) {
        System.out.printf(MessageConstant.TOTAL_PROFIT, profit);
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
