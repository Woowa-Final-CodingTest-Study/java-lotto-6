package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoProfit;
import lotto.domain.LottoResult;
import lotto.domain.WinningLottoNumbers;
import lotto.view.OutputView;

public class LottoRankingController {

    LottoProfit lottoProfit = new LottoProfit();
    OutputView outputView = new OutputView();

    public void printWinningStatistics(LottoNumbers lottoNumbers, WinningLottoNumbers winningLottoNumbers) {
        Map<String, Integer> ranking = compareLottoNumbers(lottoNumbers, winningLottoNumbers);
        outputView.printWinningStatistics(ranking);

        String profit = lottoProfit.generateProfit(ranking, lottoNumbers.getSize());
        outputView.printTotalProfit(profit);
    }

    public Map<String, Integer> compareLottoNumbers(LottoNumbers lottoNumbers, WinningLottoNumbers winningLottoNumbers) {
        LottoResult winningResult = new LottoResult();

        for(int i=0; i<lottoNumbers.getSize(); i++){
            Lotto lotto = lottoNumbers.getEachLotto(i);
            List<Integer> numbers = lotto.getEachLottoNumbers();

            winningResult.updateResult(numbers, winningLottoNumbers);
        }
        return winningResult.getLottoResult();
    }

}
