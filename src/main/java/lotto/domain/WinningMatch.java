package lotto.domain;

import static lotto.contants.Words.BONUS_BALL;
import static lotto.contants.Words.LOTTO_MATCH;
import static lotto.contants.Words.MATCH_COUNT_UNIT;
import static lotto.contants.Words.WON;

import lotto.utils.NumberUtils;

public enum WinningMatch {
    FIFTH_PRIZE(5000, 3),
    FOURTH_PRIZE(50000, 4),
    THIRD_PRIZE(1500000, 5, false),
    SECOND_PRIZE(30000000, 5, true),
    FIRST_PRIZE(2000000000, 6);

    private final int prizeMoney;
    private final int matchNumber;
    private final boolean isBonusMatched;

    WinningMatch(int prizeMoney, int matchNumber) {
        this.prizeMoney = prizeMoney;
        this.matchNumber = matchNumber;
        this.isBonusMatched = false;
    }

    WinningMatch(int prizeMoney, int matchNumber, boolean isBonusMatched) {
        this.prizeMoney = prizeMoney;
        this.matchNumber = matchNumber;
        this.isBonusMatched = isBonusMatched;
    }

    public static WinningMatch getWinningMatch(int matchNumber, boolean isBonusMatched) {
        if (matchNumber == 5) {
            if (isBonusMatched) {
                return SECOND_PRIZE;
            }
            return THIRD_PRIZE;
        }

        for (WinningMatch winningMatch : WinningMatch.values()) {
            if (winningMatch.matchNumber == matchNumber) {
                return winningMatch;
            }
        }
        return null;
    }

    public String getWinningMatchString(WinningMatch winningMatch) {
        String result = "";
        result += (winningMatch.matchNumber + MATCH_COUNT_UNIT + LOTTO_MATCH);
        if (winningMatch.matchNumber == 5 && winningMatch.isBonusMatched) {
            result += ", " + BONUS_BALL + " " + LOTTO_MATCH;
        }
        result += (" (" + NumberUtils.formatCurrency(winningMatch.prizeMoney) + WON + ")");
        return result;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
