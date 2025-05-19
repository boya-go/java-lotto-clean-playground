package domain;

import java.util.Arrays;
import java.util.List;

public class LottoWinningNumber {

    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String WINNING_NUMBER_MUST_BE_A_NUMBER = "숫자만 입력할 수 있습니다.";
    private static final String WINNING_NUMBER_NOT_ENTERED = "당첨 번호를 입력해야 합니다.";
    private final LottoNumbers winningNumbers;

    public LottoWinningNumber(final String input) {
        validateEmpty(input);
        this.winningNumbers = new LottoNumbers(parseWinningNumbers(input));
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    private List<Integer> parseWinningNumbers(final String input) {
        try {
            List<Integer> winningNumberList = Arrays.stream(input.split(WINNING_NUMBER_DELIMITER))
                    .map(String::strip)
                    .map(Integer::parseInt)
                    .toList();
            return winningNumberList;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBER_MUST_BE_A_NUMBER);
        }
    }

    private void validateEmpty(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(WINNING_NUMBER_NOT_ENTERED);
        }
    }
}
