package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class BonusNumberController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public int receiveInputBonusNumber() {
        outputView.displayBonusLottoNumberPrompt();

        try{
            int bonusNumber = inputView.inputValue();
            validateBonusNumberRange(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return receiveInputBonusNumber();
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자만 입력해주세요.");
        }
    }
}
