package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public WinningMatch calculateWinningMatch(Lotto lottoNumbers) {
        return WinningMatch.getWinningMatch(countMatchNumber(lottoNumbers), isBonusMatched(lottoNumbers));
    }

    public int countMatchNumber(Lotto lottoNumbers) {
        List<Integer> numbers = this.winningNumbers.getNumbers();
        return (int) lottoNumbers.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean isBonusMatched(Lotto lottoNumbers) {
        return lottoNumbers.getNumbers().contains(bonusNumber);
    }
}
