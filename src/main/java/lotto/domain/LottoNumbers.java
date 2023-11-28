package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private final List<Lotto> lottoNumbers;

    public LottoNumbers(List<Lotto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int getSize() {
        return lottoNumbers.size();
    }

    public List<Lotto> getLotto() {
        return new ArrayList<>(lottoNumbers);
    }

    public Lotto getEachLotto(int index) {
        return lottoNumbers.get(index);
    }
}
