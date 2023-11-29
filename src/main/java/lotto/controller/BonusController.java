package lotto.controller;

import static lotto.utils.GameMessage.REQUEST_BONUS_INPUT;

import lotto.domain.Bonus;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BonusController {
    public Bonus receiveBonus(WinningNumbers winningNumbers) {
        Bonus bonus;
        do {
            try {
                OutputView.printMessage(REQUEST_BONUS_INPUT.getMessage());
                bonus = InputView.requestBonusInput(winningNumbers);
                return bonus;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
                bonus = null;
            }
        } while (bonus == null);
        return bonus;
    }
}
