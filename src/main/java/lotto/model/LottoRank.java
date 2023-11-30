package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    LOSE(6),
    FIFTH(5, 3, 5000),
    FORTH(4, 4, 50000),
    THIRD(3, 5, 1500000, false),
    SECOND(2, 5, 30000000, true),
    FIRST(1, 6, 2000000000);
    public int rank;
    public int matchCount;
    public int prize;
    public boolean isBonusMatched;

    LottoRank(int rank) {
        this.rank = rank;
    }
    LottoRank(int rank, int matchCount, int prize) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    LottoRank(int rank, int matchCount, int prize, boolean isBonusMatched) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prize = prize;
        this.isBonusMatched = isBonusMatched;
    }

    public static LottoRank of(int matchCount, boolean isBonusMatched) {
        if (matchCount < 3)
            return LottoRank.LOSE;
        return Arrays.stream(LottoRank.values()).filter(rank -> {
                    if (rank.isBonusMatched) {
                        return isBonusMatched && matchCount == rank.matchCount;
                    }
                    return matchCount == rank.matchCount;
                })
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
