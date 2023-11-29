package lotto.controller;

import static lotto.utils.GameMessage.REQUEST_WINNING_NUMBERS_INPUT;

import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningNumberController {
    public WinningNumbers receiveWinningNumbers() {
        WinningNumbers winningNumbers;
        do {
            try {
                OutputView.printMessage(REQUEST_WINNING_NUMBERS_INPUT.getMessage());
                winningNumbers = InputView.requestWinningNumbers();
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
                winningNumbers = null;
            }
        } while (winningNumbers == null);
        return winningNumbers;
    }
}
