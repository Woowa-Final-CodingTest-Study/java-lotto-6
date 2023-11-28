package lotto.domain;

import lotto.utils.NumberUtils;

public enum WinningMatch {
    FIRST_PRIZE(2000000000, 6),
    SECOND_PRIZE(30000000, 5, true),
    THIRD_PRIZE(1500000, 5, false),
    FOURTH_PRIZE(50000, 4),
    FIFTH_PRIZE(5000, 3);

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

    static WinningMatch getWinningMatch(int matchNumber, boolean isBonusMatched) {
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
        result += (winningMatch.matchNumber + "개 일치");
        if (winningMatch.matchNumber == 5 && winningMatch.isBonusMatched) {
            result += ", 보너스 볼 일치";
        }
        result += (" (" + NumberUtils.formatCurrency(winningMatch.prizeMoney) + "원)");
        return result;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
