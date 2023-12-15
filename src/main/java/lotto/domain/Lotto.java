package lotto.domain;

import static lotto.constant.ErrorMessage.LIMIT_LOTTO_COUNT;
import static lotto.constant.ErrorMessage.SELECT_DUPLICATE;
import static lotto.constant.NumberConstant.MAX_LOTTO_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(String.format(LIMIT_LOTTO_COUNT.getMessage(), MAX_LOTTO_COUNT.getValue()));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for(int number : numbers) {
            if(!set.add(number)) {
                throw new IllegalArgumentException(SELECT_DUPLICATE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
