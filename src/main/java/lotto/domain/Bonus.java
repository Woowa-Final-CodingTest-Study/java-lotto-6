package lotto.domain;

import static lotto.utils.NumberConstants.LOTTO_MAX_NUMBER;
import static lotto.utils.NumberConstants.LOTTO_MIN_NUMBER;

import lotto.utils.ErrorMessage;

public class Bonus {
    private final int bonus;

    public Bonus(WinningNumbers winningNumbers, int bonus) {
        validateBonus(winningNumbers, bonus);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    private void validateBonus(WinningNumbers winningNumbers, int bonus) {
        validateBonusRange(bonus);
        validateDuplication(winningNumbers, bonus);
    }

    private void validateBonusRange(int bonus) {
        if (bonus < LOTTO_MIN_NUMBER.getValue() || bonus > LOTTO_MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getMessage());
        }
    }

    private static void validateDuplication(WinningNumbers winningNumbers, int bonus) {
        if (winningNumbers.getWinningNumbers().contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_ERROR.getMessage());
        }
    }
}
