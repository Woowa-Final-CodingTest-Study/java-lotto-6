package lotto.constant;

public enum NumberConstant {

    PURCHASE_UNIT(1_000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    MAX_PURCHASE_AMOUNT(2_100_000_000);

    private final int value;

    NumberConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
