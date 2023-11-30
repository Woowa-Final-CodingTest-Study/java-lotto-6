package lotto.constant;

public class ErrorMessage {
    public static final String INPUT_MUST_NUMBER = "[ERROR] 숫자만 입력해야 합니다.";
    public static final String AMOUNT_MUST_POSITIVE = "[ERROR] 구입 금액은 0보다 커야 합니다.";
    public static final String AMOUNT_MUST_DIVISIBLE = "[ERROR] 1,000원 단위로 입력해야 합니다."; // TODO: 로또 가격 변수를 넣어서 구현?
    public static final String LOTTO_INPUT_LENGTH_MUST_6 = "[ERROR] 6개를 입력해야 합니다.";
    public static final String LOTTO_NUMBER_MUST_WITHIN_RANGE = "[ERROR] 모든 번호는 1-45 범위에 있어야 합니다.";
    public static final String LOTTO_NUMBER_MUST_NOT_DUPLICATED = "[ERROR] 모든 번호는 중복되지 않아야 합니다.";
}
