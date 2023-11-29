package lotto.controller;

import static lotto.utils.GameMessage.REQUEST_BONUS_INPUT;
import static lotto.utils.GameMessage.REQUEST_INPUT_MONEY;
import static lotto.utils.GameMessage.REQUEST_WINNING_NUMBERS_INPUT;

import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Service;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;


public class Controller {
    Service service = new Service();

    public void init() {
        Money money = enrollMoney();
        int ticketCount = service.convertToTicket(money);
        Lottos lottos = service.generateUserLottos(ticketCount);
        service.printUserLottos(lottos, ticketCount);
        WinningNumbers winningNumbers = enrollWinningNumbers();
        Bonus bonus = enrollBonus(winningNumbers);
        // Map<Rank, Integer> rankCount = checkLottoGameResult(lottos, winningNumbers, bonus);
    }

    public Money enrollMoney() {
        Money money;
        do {
            try {
                OutputView.printMessage(REQUEST_INPUT_MONEY.getMessage());
                money = InputView.requestMoneyInput();
                return money;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
                money = null;
            }
        } while (money == null);
        return money;
    }

    public WinningNumbers enrollWinningNumbers() {
        WinningNumbers winningNumbers;
        do {
            try {
                OutputView.printMessage(REQUEST_WINNING_NUMBERS_INPUT.getMessage());
                winningNumbers = InputView.requestWinningNumbers();
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
                winningNumbers = null;
            }
        } while (winningNumbers == null);
        return winningNumbers;
    }

    public Bonus enrollBonus(WinningNumbers winningNumbers) {
        Bonus bonus;
        do {
            try {
                OutputView.printMessage(REQUEST_BONUS_INPUT.getMessage());
                bonus = InputView.requestBonusInput(winningNumbers);
                return bonus;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
                bonus = null;
            }
        } while (bonus == null);
        return bonus;
    }

//    private Map<Rank, Integer> checkLottoGameResult(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
//        Map<Rank, Integer> rankCount = service.calculateRankCount(lottos, winningNumbers, bonusNumber);
//        OutputView.printWinningStatistics();
//        return rankCount;
//    }
//
//    private void printWinningStatistics(Map<Rank, Integer> rankCount, Money money) {
//        OutputView.printRankCount(rankCount);
//        service.printRateOfReturn(rankCount, money);
//    }
}

