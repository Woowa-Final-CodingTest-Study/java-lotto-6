package lotto.controller;

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
        
    }
}
