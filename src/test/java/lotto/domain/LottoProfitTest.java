package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitTest {

    private LottoProfit lottoProfit;

    @BeforeEach
    void setUp() {
        lottoProfit = new LottoProfit();
    }

    @DisplayName("수익률 계산이 맞는지 확인")
    @Test
    void checkCorrectProfit() {
        long totalPrize = 5000;
        int purchaseAmount = 13000;
        String result = lottoProfit.calculateProfit(totalPrize, purchaseAmount);
        String answer = "38.5";

        assertThat(result).isEqualTo(answer);
    }
}