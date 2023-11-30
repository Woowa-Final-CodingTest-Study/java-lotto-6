package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.utils.NumberConstants;

public class NumberGenerator {
    public NumberGenerator() {
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = createRandomNumbersInRange(
                NumberConstants.LOTTO_MIN_NUMBER, NumberConstants.LOTTO_MAX_NUMBER, NumberConstants.LOTTO_NUMBER_COUNTS);
        sortNumbers(numbers);
        return numbers;
    }

    private List<Integer> createRandomNumbersInRange(NumberConstants min, NumberConstants max, NumberConstants count) {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(min.getValue(), max.getValue(), count.getValue()));
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
