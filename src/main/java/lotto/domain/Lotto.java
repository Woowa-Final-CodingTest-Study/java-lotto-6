package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateAndRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해주세요.");
        }
    }

    private void validateDuplicateAndRange(List<Integer> numbers) {
        Set<Integer> deleteDuplicateNumbers = new HashSet<>();

        for(int number : numbers) {
            if(!deleteDuplicateNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다.");
            }
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자만 입력해주세요.");
            }
        }
    }

    public List<Integer> getEachLottoNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(numbers));
    }

}
