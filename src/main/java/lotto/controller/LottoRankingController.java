package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoMatching;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoProfit;
import lotto.domain.LottoRank;
import lotto.view.OutputView;

public class LottoRankingController {

    LottoMatching lottoMatching = new LottoMatching();
    LottoProfit lottoProfit = new LottoProfit();
    LottoRank lottoRank = new LottoRank();
    OutputView outputView = new OutputView();

    public void printWinningStatistics(LottoNumbers lottoNumbers, Lotto winningLotto, int bonusNumber) {
        Map<String, Integer> ranking = compareLottoNumbers(lottoNumbers, winningLotto, bonusNumber);
        outputView.printWinningStatistics(ranking);

        String profit = lottoProfit.generateProfit(ranking, lottoNumbers.getSize());
        outputView.printTotalProfit(profit);
    }

    public Map<String, Integer> compareLottoNumbers(LottoNumbers lottoNumbers, Lotto winningLotto, int bonusNumber) {
        Map<String, Integer> ranking = lottoRank.initializeRank();
        List<Integer> winningNumbers = winningLotto.getEachLottoNumbers();

        for(int i=0; i<lottoNumbers.getSize(); i++){
            Lotto lotto = lottoNumbers.getEachLotto(i);
            List<Integer> numbers = lotto.getEachLottoNumbers();

            updateRanking(ranking, numbers, winningNumbers, bonusNumber);
        }
        return ranking;
    }

    public void updateRanking(
            Map<String, Integer> ranking,
            List<Integer> numbers,
            List<Integer> winningNumbers,
            int bonusNumber) {
        int matchingCount = lottoMatching.matchingLottoNumbers(numbers, winningNumbers);
        boolean existBonus = lottoMatching.matchingBonusNumber(numbers, bonusNumber);

        String rank = lottoRank.rankLotto(matchingCount, existBonus);

        ranking.put(rank, ranking.getOrDefault(rank, 0)+1);
    }

}
