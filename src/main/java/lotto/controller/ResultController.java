package lotto.controller;

import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.service.PrizeService;
import lotto.domain.WinningNumbers;
import lotto.view.OutputView;

public class ResultController {
    PrizeService prizeService = new PrizeService();

    public void checkLottoGameResult(Lottos lottos, WinningNumbers winningNumbers, Bonus bonus, Money money) {
        Map<Rank, Integer> rankCount = lottos.calculateRankCount(winningNumbers, bonus);
        OutputView.printWinningStatistics(rankCount);
        double rateOfReturn = prizeService.calculateRateOfReturn(rankCount, money);
        OutputView.printRateOfReturn(rateOfReturn);
    }
}
