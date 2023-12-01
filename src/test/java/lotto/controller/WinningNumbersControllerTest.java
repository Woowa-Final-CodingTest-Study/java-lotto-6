package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersControllerTest {

    @DisplayName("보너스 번호가 1부터 45사이의 숫자가 아닌 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void checkBonusNumberRange(int input) {
        WinningNumbersController winningNumbersController = new WinningNumbersController();
        assertThatThrownBy(() -> winningNumbersController.validateBonusNumberRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}