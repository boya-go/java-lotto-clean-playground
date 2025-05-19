package view;

import domain.Lotto;
import domain.Rank;
import domain.WinningStatistics;
import java.util.Arrays;
import java.util.List;

public class OutputView {

    private static final String PURCHASED_LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_RESULT_TITLE = "당첨 통계%n---------%n";
    private static final String LOTTO_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printPurchasedLottoAmount(int lottoAmount) {
        System.out.println();
        System.out.printf((PURCHASED_LOTTO_AMOUNT_MESSAGE)+"%n",lottoAmount);
    }

    public static void printLottoTicket(List<Lotto> lottoTicket) {
        for (Lotto lotto : lottoTicket) {
            System.out.println(lotto.getNumbersAsList());
        }
    }

    public static void printWinningStatistics(final WinningStatistics winningStatistics) {
        System.out.println();
        System.out.printf(LOTTO_RESULT_TITLE);
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> System.out.printf(
                        "%d개 일치 (%d원)- %d개%n",
                        rank.getMatchCount(),
                        rank.getPrize(),
                        winningStatistics.getCount(rank)
                ));
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.", profitRate);
        if (profitRate < 1) {
            System.out.println(LOTTO_LOSS_MESSAGE);
        }
    }
}
