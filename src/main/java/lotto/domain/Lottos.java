package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> userLottos;

    public Lottos (List<Lotto> numbers) {
        this.userLottos = Collections.unmodifiableList(numbers);
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }
}
