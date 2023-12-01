package lotto.domain;

import java.util.List;

public class LottoNumbers {

    private final List<Lotto> lottoNumbers;

    public LottoNumbers(List<Lotto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int getSize() {
        return lottoNumbers.size();
    }

    public Lotto getEachLotto(int index) {
        return lottoNumbers.get(index);
    }

}
