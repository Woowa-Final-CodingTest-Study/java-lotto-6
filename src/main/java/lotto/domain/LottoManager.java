package lotto.domain;

import lotto.utils.NumberConstants;

public class LottoManager {
    public int convertToTicketCount(Money money) {
        int ticketCount = (money / NumberConstants.MONEY_UNIT.getValue());
        return ticketCount;
    }
}
