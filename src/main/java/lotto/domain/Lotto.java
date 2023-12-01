package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessageConstant;
import lotto.constant.NumberConstant;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateAndRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NumberConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessageConstant.PREFIX + ErrorMessageConstant.WINNING_NUMBERS_SIZE);
        }
    }

    private void validateDuplicateAndRange(List<Integer> numbers) {
        Set<Integer> deleteDuplicateNumbers = new HashSet<>();

        for(int number : numbers) {
            if(!deleteDuplicateNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessageConstant.PREFIX + ErrorMessageConstant.DUPLICATED_NUMBER);
            }
            if(number < NumberConstant.MIN_NUMBER || number > NumberConstant.MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessageConstant.PREFIX + ErrorMessageConstant.INPUT_NUMBERS_IN_RANGE);
            }
        }
    }

    public List<Integer> getEachLottoNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(numbers));
    }

}
