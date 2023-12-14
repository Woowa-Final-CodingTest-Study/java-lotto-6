package lotto.constant;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    INPUT_NULL(ERROR + "입력값을 확인하세요"),
    INPUT_NUMBER(ERROR + "숫자를 입력하세요"),
    INPUT_POSITIVE_NUMBER(ERROR + "음수는 입력할 수 없습니다."),
    INPUT_AMOUNT_UNIT(ERROR + "%d원 단위로 입력해야 합니다."),
    LIMIT_PURCHASE_AMOUNT(ERROR + "구매금액은 %.d원을 넘길 수 없습니다."),
    INPUT_CORRECT_SEPARATOR(ERROR + "쉼표(,)를 사용하여 입력해야 합니다."),
    LIMIT_LOTTO_NUMBER(ERROR + "%d부터 %d사이의 숫자만 입력해야 합니다."),
    INPUT_DUPLICATE(ERROR + "중복되는 숫자는 입력할 수 없습니다."),
    INPUT_DUPLICATE_WIN_NUMBER(ERROR + "당첨 번호와 중복되는 숫자는 사용할 수 없습니다."),
    SELECT_DUPLICATE(ERROR + "중복되는 숫자를 뽑았습니다."),
    LIMIT_LOTTO_COUNT(ERROR + "로또 번호는 %d개까지만 생성 할 수 있습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
