package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoNumbersTest {

    private WinningLottoNumbers winningLottoNumbers;

    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치하는 번호 개수를 확인")
    @ParameterizedTest
    @MethodSource("provideWinningLottoNumbers")
    void checkMatchingLottoNumberCount(List<Integer> lottoNumbers, List<Integer> winningNumbers,
                                       int bonusNumber, int matchingCount) {
        Lotto lotto = new Lotto(winningNumbers);
        WinningLottoNumbers winningLotto = new WinningLottoNumbers(lotto, bonusNumber);
        int result = winningLotto.matchCount(lottoNumbers);

        assertThat(result).isEqualTo(matchingCount);
    }

    private static Stream<Arguments> provideWinningLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,6), 7, 6),
                Arguments.of(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,8), 8, 5)
        );
    }

    @DisplayName("로또 번호와 보너스 번호를 비교하여 일치하는 번호 개수를 확인")
    @ParameterizedTest
    @MethodSource("provideBonusNumber")
    void checkMatchingBonusNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers,
                                  int bonusNumber, boolean hasBonus) {
        Lotto lotto = new Lotto(winningNumbers);
        WinningLottoNumbers winningLotto = new WinningLottoNumbers(lotto, bonusNumber);
        boolean result = winningLotto.containBonusNumber(lottoNumbers);

        assertThat(result).isEqualTo(hasBonus);
    }

    private static Stream<Arguments> provideBonusNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,6), 7, false),
                Arguments.of(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,8), 6, true)
        );
    }

}