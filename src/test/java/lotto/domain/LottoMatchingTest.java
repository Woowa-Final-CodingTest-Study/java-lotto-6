package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMatchingTest {

    private LottoMatching lottoMatching;

    @BeforeEach
    void setUp() {
        lottoMatching = new LottoMatching();
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 일치하는 번호 개수를 확인")
    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    void checkMatchingLottoNumberCount(List<Integer>lottoNumbers, List<Integer> winningNumbers, int matchingCount) {
        int result = lottoMatching.matchingLottoNumbers(lottoNumbers, winningNumbers);

        assertThat(result).isEqualTo(matchingCount);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,6), 6),
                Arguments.of(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,8), 5)
        );
    }

    @DisplayName("로또 번호와 보너스 번호를 비교하여 일치하는 번호 개수를 확인")
    @ParameterizedTest
    @MethodSource("provideBonusNumber")
    void checkMatchingBonusNumber(List<Integer> lottoNumbers, int bonusNumber, boolean hasBonus) {
        boolean result = lottoMatching.matchingBonusNumber(lottoNumbers, bonusNumber);

        assertThat(result).isEqualTo(hasBonus);
    }

    private static Stream<Arguments> provideBonusNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), 6, true),
                Arguments.of(Arrays.asList(1,2,3,4,5,6), 9, false)
        );
    }
}