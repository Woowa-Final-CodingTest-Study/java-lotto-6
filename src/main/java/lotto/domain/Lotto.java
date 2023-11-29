package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Rank match(WinningNumbers winningNumbers, Bonus bonus) {
        int countOfMatch = countMatchingNumbers(winningNumbers);
        boolean matchBonus = containsBonusNumber(bonus);
        return Rank.calculateRank(countOfMatch, matchBonus);
    }

    public int countMatchingNumbers(WinningNumbers winningNumbers) {
        int count = 0;
        for (Integer number : this.numbers) {
            if (winningNumbers.getWinningNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean containsBonusNumber(Bonus bonus) {
        return this.numbers.contains(bonus.getBonus());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
