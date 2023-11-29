package lotto.domain;

import java.util.List;

public class LottoMatching {

    public int matchingLottoNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean matchingBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {

        return lottoNumbers.contains(bonusNumber);
    }

}
