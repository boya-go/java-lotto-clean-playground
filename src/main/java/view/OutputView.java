package view;

import domain.Lotto;
import java.util.List;

public class OutputView {

    private static final String PURCHASED_LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.";

    public static void printPurchasedLottoAmount(int lottoAmount) {
        System.out.println();
        System.out.printf((PURCHASED_LOTTO_AMOUNT_MESSAGE)+"%n",lottoAmount);
    }

    public static void printLottoTicket(List<Lotto> lottoTicket) {
        for (Lotto lotto : lottoTicket) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
