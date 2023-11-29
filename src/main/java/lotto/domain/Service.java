package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public int convertToTicket(Money money) {
        int ticketCount = money.calculateTicketCount();
        return ticketCount;
    }

    public Lotto generateLottoTicket(int ticketCount) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            int number = Randoms.pickNumberInRange(1,45);
            numbers.add(number);
        }
        return new Lotto(numbers);
    }
}
