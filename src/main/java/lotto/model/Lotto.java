package lotto.model;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int RANGE_MIN = 1;
    public static final int RANGE_MAX = 45;
    public static final int LENGTH = 6;
    public static int PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isPresent = numbers.stream()
                .anyMatch(n -> n < Lotto.RANGE_MIN || n > Lotto.RANGE_MAX);
        if(isPresent)
            throw new IllegalArgumentException();
    }

    private void validateUnique(List<Integer> numbers) {
        if(numbers.size() != new HashSet<>(numbers).size())
            throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "[" +
                numbers.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", ")) +
                "]";
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public LottoRank rank(Lotto winningLotto, int bonusNumber) {
        List<Integer> newNumbers = new ArrayList<>(numbers);
        newNumbers.retainAll(winningLotto.numbers);
        return LottoRank.of(newNumbers.size(), numbers.contains(bonusNumber));
    }
}
