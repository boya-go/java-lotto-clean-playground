package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNIGNUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static int enterLottoPuchase() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
        return scanner.nextInt();
    }

    public static String enterLottoWinningNumber() {
        System.out.println(INPUT_WINNIGNUMBER_MESSAGE);
        return scanner.nextLine();
    }
}
