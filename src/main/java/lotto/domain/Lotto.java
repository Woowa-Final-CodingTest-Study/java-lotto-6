package lotto.domain;

import static lotto.contants.Words.LOTTO_SIZE;
import static lotto.contants.Words.MAX_LOTTO_NUMBER;
import static lotto.contants.Words.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = List.copyOf(numbers);
    }

    public String getNumbersWithComma() {
        return List.copyOf(numbers).stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
