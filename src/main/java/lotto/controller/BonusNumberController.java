package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class BonusNumberController {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

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

    public void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자만 입력해주세요.");
        }
    }

}
