package lotto.controller;

import static lotto.constant.NumberConstant.PURCHASE_UNIT;
import static lotto.constant.SystemMessage.PROFIT;
import static lotto.constant.SystemMessage.PURCHASE_LOTTO;
import static lotto.constant.SystemMessage.WIN_RESULT;

import java.util.List;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class MainController {

    InputService inputService = new InputService();
    LottoService lottoService = new LottoService();
    OutputView outputView = new OutputView();

    public void run() {
        int purchasePrice = inputService.getPurchaseAmount();
        generateLottoNumbers(purchasePrice);
        List<Integer> winNumbers = inputService.getWinNumbers();
        int bonusNumber = inputService.getBonusNumber(winNumbers);
        matchNumbers(winNumbers, bonusNumber);
        printMatchResult();
        printTotalProfit(purchasePrice);
    }

    public void generateLottoNumbers(int purchasePrice) {
        int purchaseAmount = purchasePrice / PURCHASE_UNIT.getValue();
        lottoService.generateLottoNumbers(purchaseAmount);
        outputView.print(String.format(PURCHASE_LOTTO.getMessage(), purchaseAmount));
        outputView.print(lottoService.getLottoNumbers().toString());
    }

    public void matchNumbers(List<Integer> winNumbers, int bonusNumber) {
        lottoService.matchLottoNumbers(winNumbers, bonusNumber);
    }

    public void printMatchResult() {
        outputView.print(WIN_RESULT.getMessage());
        outputView.print(lottoService.getMatchResult());
    }

    public void printTotalProfit(int purchasePrice) {
        String totalProfit = lottoService.generateProfit(purchasePrice);
        outputView.print(String.format(PROFIT.getMessage(), totalProfit));
    }
}
