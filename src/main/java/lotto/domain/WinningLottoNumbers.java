package lotto.domain;

import java.util.List;

public class WinningLottoNumbers {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLottoNumbers(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(lotto.getEachLottoNumbers()::contains)
                .count();
    }
    public boolean containBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

}
