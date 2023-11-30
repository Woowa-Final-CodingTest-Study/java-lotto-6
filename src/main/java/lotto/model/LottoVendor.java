package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoVendor {
    private static final RandomGenerator randomLottoGenerator = new RandomGenerator(Lotto.RANGE_MIN, Lotto.RANGE_MAX, Lotto.LENGTH);

    public static LottoBundle generateLottoBundle(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount/Lotto.PRICE; i++) {
            Lotto lotto = new Lotto(randomLottoGenerator.next());
            lottos.add(lotto);
        }
        return new LottoBundle(lottos);
    }
}
