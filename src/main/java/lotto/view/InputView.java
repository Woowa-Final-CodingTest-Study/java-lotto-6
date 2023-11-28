package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String receiveInputPurchaseAmount() {
        String input = Console.readLine();
        validateNull(input);
        validateNumeric(input);

        return input;
    }

    private void validateNull(String input) {
        if(input.isEmpty()) {
            throw new NullPointerException("[ERROR] 아무값도 입력하지 않았습니다.");
        }
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("[ERROR] 입력값을 확인해주세요.");
        }
    }
}
