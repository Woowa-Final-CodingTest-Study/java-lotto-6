package lotto.constant;

public enum Rank {

    FIFTH(3,5, 5_000),
    FORTH(4,4, 50_000),
    THIRD(5,3, 1_500_000, false),
    SECOND(5,2, 30_000_000, true),
    FIRST(6,1, 2_000_000_000);

    private final int matchCount;
    private final int prize;
    private final int prizeAmount;
    private boolean isBonus = false;

    Rank(int matchCount, int prize, int prizeAmount) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.prizeAmount = prizeAmount;
    }

    Rank(int matchCount, int prize, int prizeAmount, boolean isBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.prizeAmount = prizeAmount;
        this.isBonus = isBonus;
    }

    public static int findRankByMatchCount(int matchCount) {
        for(Rank rank : Rank.values()) {
            if(matchCount == rank.matchCount) {
                return rank.prize;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int findBonusPrize(int matchCount) {
        for(Rank rank : Rank.values()) {
            if(matchCount == 5 && rank.isBonus()) {
                return rank.getPrize();
            }
        }
        throw new IllegalArgumentException();
    }

    public static int findPrizeAmount(int ranking) {
        for(Rank rank : Rank.values()) {
            if(ranking == rank.getPrize()) {
                return rank.getPrizeAmount();
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

}
