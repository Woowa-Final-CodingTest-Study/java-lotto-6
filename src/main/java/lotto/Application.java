package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();

        LottoController controller = LottoController.getInstance(inputView, outputView);

        controller.start();
    }
}
