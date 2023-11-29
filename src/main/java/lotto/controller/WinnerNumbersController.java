package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinnerNumbersController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public Lotto receiveInputWinnerLottoNumbers() {
        outputView.displayWinnerLottoNumbersPrompt();

        try {
            List<Integer> winnerLottoNumbers = inputView.inputWinnerLottoNumbers();
            return new Lotto(winnerLottoNumbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return receiveInputWinnerLottoNumbers();
        }
    }

}
