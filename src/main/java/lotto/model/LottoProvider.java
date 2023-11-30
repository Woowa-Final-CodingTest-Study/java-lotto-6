package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoProvider {
    private static final RandomGenerator randomLottoGenerator = new RandomGenerator(Lotto.RANGE_MIN, Lotto.RANGE_MAX, Lotto.LENGTH);
    private final int amount;

    public LottoProvider(int amount) {

        this.amount = amount;
    }

    public LottoBundle generateLottoBundle() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < getCount(); i++) {
            Lotto lotto = new Lotto(randomLottoGenerator.next());
            lottos.add(lotto);
        }
        return new LottoBundle(lottos);
    }

    public int getCount() {
        return amount/Lotto.PRICE;
    }
}
