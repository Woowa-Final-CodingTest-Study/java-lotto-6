package lotto.utils;

public enum ErrorMessage {
    INVALID_MONEY_UNIT_ERROR("[ERROR] 단위는 1,000원이어야 합니다."),
    INVALID_MONEY_NOT_INTEGER_ERROR("[ERROR] 구입금액은 정수를 입력해야 합니다."),
    INVALID_MONEY_RANGE_ERROR("[ERROR] 구입금액의 범위가 올바르지 않습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
