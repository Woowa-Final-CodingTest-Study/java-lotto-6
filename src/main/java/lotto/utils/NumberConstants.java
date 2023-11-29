package lotto.utils;

public enum NumberConstants {
    MIN_MONEY(1000),
    MAX_MONEY(1_000_000),
    MONEY_UNIT(1000),
    LOTTO_NUMBER_COUNTS(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);

    private final int value;

    NumberConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
