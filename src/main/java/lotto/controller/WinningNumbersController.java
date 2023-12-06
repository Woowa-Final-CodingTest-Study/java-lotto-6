package lotto.controller;

import java.util.List;
import lotto.constant.ErrorMessageConstant;
import lotto.constant.NumberConstant;
import lotto.domain.Lotto;
import lotto.domain.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningNumbersController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public WinningLottoNumbers getWinningLottoNumbers() {
        Lotto winningNumbers = receiveInputWinnerLottoNumbers();
        int bonusNumber = receiveInputBonusNumber();
        return new WinningLottoNumbers(winningNumbers, bonusNumber);
    }

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

    public int receiveInputBonusNumber() {
        outputView.displayBonusLottoNumberPrompt();

        try {
            int bonusNumber = inputView.inputBonusNumber();
            validateBonusNumberRange(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return receiveInputBonusNumber();
        }
    }

    public void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < NumberConstant.MIN_NUMBER || bonusNumber > NumberConstant.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    ErrorMessageConstant.PREFIX + ErrorMessageConstant.INPUT_NUMBERS_IN_RANGE);
        }
    }

}
