package lotto.domain;

import static lotto.utils.NumberConstants.LOTTO_MAX_NUMBER;
import static lotto.utils.NumberConstants.LOTTO_MIN_NUMBER;
import static lotto.utils.NumberConstants.LOTTO_NUMBER_COUNTS;
import static lotto.utils.NumberConstants.MAX_MONEY;
import static lotto.utils.NumberConstants.MIN_MONEY;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.ErrorMessage;
import lotto.utils.NumberConstants;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void validateNumbers(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            validateNumberRange(number);
        }
        validateNumberCounts(winningNumbers);
        validateNoDuplicates(winningNumbers);
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER.getValue() || number > LOTTO_MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getMessage());
        }
    }

    private void validateNoDuplicates(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNTS.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER_ERROR.getMessage());
        }
    }

    private void validateNumberCounts(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNTS.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_WINNING_NUMBER_ERROR.getMessage());
        }
    }
}
