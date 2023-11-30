package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static LottoController lottoController;
    private final InputView inputView;
    private final OutputView outputView;

    private LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static LottoController getInstance(InputView inputView, OutputView outputView) {
        if (lottoController == null) {
            lottoController = new LottoController(inputView, outputView);
        }
        return lottoController;
    }

    public void start() {
        outputView.notifyInputAmount();
        int amount = inputView.readAmount();

        LottoBundle lottoBundle = LottoVendor.generateLottoBundle(amount);
        outputView.printGeneratedLottoResults(lottoBundle);

        outputView.notifyInputLottoNumbers();
        Lotto winningLotto = inputView.readLottoNumbers();

        outputView.notifyInputBonusNumber();
        int bonusNumber = inputView.readBonusNumber(winningLotto);

        WinningManager winningManager = new WinningManager(winningLotto, bonusNumber);
        WinningResult result = winningManager.getResult(amount, lottoBundle);

        outputView.printResult(result);
    }
}
