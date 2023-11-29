package lotto.constant;

public enum Rank {
    FIFTH(3, false, 5_000),
    FORTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchingCount;
    private final boolean bonus;
    private final int prize;

    Rank(int matchingCount, boolean bonus, int prize) {
        this.matchingCount = matchingCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getPrize() {
        return prize;
    }

    public static String assignRank(int matchingCount, boolean bonus) {
        for(Rank rank : Rank.values()) {
            if(rank.getMatchingCount() == matchingCount &&
                    rank.isBonus() == bonus) {
                return rank.name();
            }
        }
        return "없음";
    }
}
