package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessageConstant;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateAndRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessageConstant.PREFIX + ErrorMessageConstant.WINNING_NUMBERS_SIZE);
        }
    }

    private void validateDuplicateAndRange(List<Integer> numbers) {
        Set<Integer> deleteDuplicateNumbers = new HashSet<>();

        for(int number : numbers) {
            if(!deleteDuplicateNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessageConstant.PREFIX + ErrorMessageConstant.DUPLICATED_NUMBER);
            }
            if(number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessageConstant.PREFIX + ErrorMessageConstant.INPUT_NUMBERS_IN_RANGE);
            }
        }
    }

    public List<Integer> getEachLottoNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(numbers));
    }

}
