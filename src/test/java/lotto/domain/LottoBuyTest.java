package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyTest {

    private LottoBuy lottoBuy;

    @BeforeEach
    void setUp() {
        lottoBuy = new LottoBuy();
    }

    @DisplayName("로또 구입 금액 입력 시 정확한 개수를 구매했는지 확인")
    @Test
    void checkLottoAmount() {
        int result = lottoBuy.calculateLottoAmount(10000);
        int answer = 10;

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("구입한 개수만큼 로또가 생성됐는지 확인")
    @Test
    void checkGenerateLotto() {
        int result = lottoBuy.gatherLottoNumbers(13).getSize();
        int answer = 13;

        assertThat(result).isEqualTo(answer);
    }
}