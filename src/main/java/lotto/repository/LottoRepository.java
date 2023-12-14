package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {

    private final List<Lotto> lottoRepository = new ArrayList<>();

    public void saveLotto(Lotto lotto) {
        lottoRepository.add(lotto);
    }

    public List<Lotto> getLotto() {
        return lottoRepository;
    }
}
