package domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningStatistics {

    private final LottoWinningNumber lottoWinningNumber;
    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

    public WinningStatistics(final LottoWinningNumber lottoWinningNumber, final LottoTicket purchasedLottos) {
        this.lottoWinningNumber = lottoWinningNumber;
        calculateRankCounts(purchasedLottos);
    }

    private void calculateRankCounts(final LottoTicket purchasedLottos) {
        for (Lotto lotto : purchasedLottos.getTicket()) {
            int matchCount = lotto.matchCountWinnings(lottoWinningNumber.getWinningNumbers());
            boolean matchBonusBall = lotto.contains(lottoWinningNumber.getBonusBall());
            Rank rank = Rank.matchCountOf(matchCount, matchBonusBall);
            rankCounts.put(rank, getCount(rank) + 1);
        }
    }

    public int getCount(final Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public long getTotalPrize() {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrize()*getCount(rank);
        }
        return totalPrize;
    }

    public Map<Rank, Integer> getRankCounts() {
        return Map.copyOf(rankCounts);
    }
}
