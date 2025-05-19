package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true,30_000_000),
    THIRD(5, false,1_500_000),
    FOURTH(4,false, 50_000),
    FIFTH(3, false,5_000),
    NONE(0, false,0);

    private final int matchCount;
    private final boolean matchBonusBall;
    private final long prize;

    Rank(int matchCount, boolean matchBonusBall, long prize) {
        this.matchCount = matchCount;
        this.matchBonusBall = matchBonusBall;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public static Rank matchCountOf(int matchCount, boolean matchBonusBall) {
        if (matchCount == 5) {
            return Arrays.stream(values())
                    .filter(rank -> rank.matchCount == 5 && rank.matchBonusBall == matchBonusBall)
                    .findFirst()
                    .orElse(NONE);
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }
}

