package lotto.utils;

public enum ErrorMessage {
    UNIT_ERROR("[ERROR] 단위는 1,000원이어야 합니다."),
    NOT_INTEGER_ERROR("[ERROR] 정수를 입력해야 합니다."),
    RANGE_ERROR("[ERROR] 범위가 올바르지 않습니다."),
    FORMAT_ERROR("[ERROR] 형식이 올바르지 않습니다"),
    DUPLICATE_WINNING_NUMBER_ERROR("[ERROR] 당첨번호는 중복될 수 없습니다."),
    DUPLICATE_BONUS_ERROR("[ERROR] 당첨번호와 보너스는 중복될 수 없습니다."),
    NOT_SIX_WINNING_NUMBER_ERROR("[ERROR] 당첨번호는 6개를 입력해야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
