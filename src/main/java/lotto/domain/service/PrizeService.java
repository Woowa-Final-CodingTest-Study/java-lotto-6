package lotto.domain.service;

import java.util.Map;
import lotto.domain.Money;
import lotto.domain.Rank;

public class PrizeService {
    public double calculateRateOfReturn(Map<Rank, Integer> rankCount, Money money) {
        double totalPrizeMoney = 0;

        for (Map.Entry<Rank, Integer> entry : rankCount.entrySet()) {
            totalPrizeMoney += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return (totalPrizeMoney / money.getMoney()) * 100;
    }
}
