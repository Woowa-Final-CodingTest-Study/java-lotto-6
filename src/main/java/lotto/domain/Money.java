package lotto.domain;

import lotto.utils.ErrorMessage;
import lotto.utils.NumberConstants;

public class Money {
    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public void validateMoney(int money) {
        boolean isValidMoney;
        do {
            if (!isValidRange(money)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_RANGE_ERROR.getMessage());
            }
            if (!isValidUnit(money)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT_ERROR.getMessage());
            }
            isValidMoney = true;
        } while (!isValidMoney);
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

    public int calculateTicketCount() {
        return (money / NumberConstants.MONEY_UNIT.getValue());
    }
}
