package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("null값을 입력하는 경우 에러 발생")
    @Test
    void checkInputValueIsNull() {
        assertThatThrownBy(() -> inputView.validateNull(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("int의 범위를 벗어나거나 숫자를 제외한 다른 문자를 입력하는 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"11111111111, -111111111111, 가나다, abc, !@#$"})
    void checkNumeric(String input) {
        assertThatThrownBy(() -> inputView.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 번호 입력시 쉼표(,)로 구분하여 입력하지 않는 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1/2/3,4,5,6", "1.2,3,4,5,6", "1!2,3,4,5,6", "1 2 3 4 5 6"})
    void checkSeparator(String input) {
        assertThatThrownBy(() -> inputView.validateInputCorrectSeparator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력한 로또 번호가 int의 범위를 벗어나거나 숫자가 아닌 다른 문자가 섞여있는 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,1111111111111", "1,2,3,4,5,ㅁ", "1,2,3,4,5,A"})
    void checkWinningNumbersNumeric(String input) {
        assertThatThrownBy(() -> inputView.validateWinnerNumberNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}