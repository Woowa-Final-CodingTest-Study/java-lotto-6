package lotto.domain;

import lotto.utils.ErrorMessage;
import lotto.utils.NumberConstants;

public class Money {
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public void validateMoney(int money) {
        if (!isValidRange(money)) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getMessage());
        }
        if (!isValidUnit(money)) {
            throw new IllegalArgumentException(ErrorMessage.UNIT_ERROR.getMessage());
        }
    }

    private boolean isValidUnit(int money) {
        if (money % NumberConstants.MONEY_UNIT.getValue() != 0) {
            return false;
        }
        return true;
    }

    private boolean isValidRange(int money) {
        if (money < NumberConstants.MIN_MONEY.getValue() || money > NumberConstants.MAX_MONEY.getValue()) {
            return false;
        }
        return true;
    }

    public int getMoney() {
        return money;
    }

    public int calculateTicketCount() {
        return (money / NumberConstants.MONEY_UNIT.getValue());
    }
}
