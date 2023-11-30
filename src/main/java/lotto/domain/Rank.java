package lotto.domain;


public enum Rank {
    MATCH_0(0, 0, 0),
    MATCH_3(3, 5000, 0),
    MATCH_4(4, 50_000, 0),
    MATCH_5(5, 1_500_000, 0),
    MATCH_5_BONUS(5, 30_000_000, 0, true),
    MATCH_6(6, 2_000_000_000, 0);

    private final int countOfMatch;
    private final int prizeMoney;
    private final int countOfWin;
    private final boolean matchBonus;

    Rank(int countOfMatch, int prizeMoney, int countOfWin) {
        this(countOfMatch, prizeMoney, countOfWin, false);
    }

    Rank(int countOfMatch, int prizeMoney, int countOfWin, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
        this.countOfWin = countOfWin;
        this.matchBonus = matchBonus;
    }

    public static Rank calculateRank(int countOfMatch, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.countOfMatch == countOfMatch && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return MATCH_0;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}


