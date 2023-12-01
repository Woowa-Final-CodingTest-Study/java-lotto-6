package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoProfit;
import lotto.domain.LottoRank;
import lotto.domain.WinningLottoNumbers;
import lotto.view.OutputView;

public class LottoRankingController {

    LottoProfit lottoProfit = new LottoProfit();
    LottoRank lottoRank = new LottoRank();
    OutputView outputView = new OutputView();

    public void printWinningStatistics(LottoNumbers lottoNumbers, WinningLottoNumbers winningLottoNumbers) {
        Map<String, Integer> ranking = compareLottoNumbers(lottoNumbers, winningLottoNumbers);
        outputView.printWinningStatistics(ranking);

        String profit = lottoProfit.generateProfit(ranking, lottoNumbers.getSize());
        outputView.printTotalProfit(profit);
    }

    public Map<String, Integer> compareLottoNumbers(LottoNumbers lottoNumbers, WinningLottoNumbers winningLottoNumbers) {
        Map<String, Integer> ranking = lottoRank.initializeRank();

        for(int i=0; i<lottoNumbers.getSize(); i++){
            Lotto lotto = lottoNumbers.getEachLotto(i);
            List<Integer> numbers = lotto.getEachLottoNumbers();

            updateRanking(ranking, numbers, winningLottoNumbers);
        }
        return ranking;
    }

    public void updateRanking(Map<String, Integer> ranking, List<Integer> numbers, WinningLottoNumbers winningLottoNumbers) {

        int matchingCount = winningLottoNumbers.matchCount(numbers);
        boolean existBonus = winningLottoNumbers.containBonusNumber(numbers);

        String rank = lottoRank.rankLotto(matchingCount, existBonus);

        if(!rank.equals("없음")) {
            ranking.put(rank, ranking.getOrDefault(rank, 0)+1);
        }
    }

}
