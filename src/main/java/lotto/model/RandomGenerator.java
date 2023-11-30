package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomGenerator {
    private final int start;
    private final int end;
    private final int count;

    public RandomGenerator(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }

    public List<Integer> next() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(start, end, count);
        return randomNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
