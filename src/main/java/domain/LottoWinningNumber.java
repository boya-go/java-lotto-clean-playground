package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumber {

    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String WINNING_NUMBER_MUST_BE_A_NUMBER = "숫자만 입력할 수 있습니다.";
    private static final String WINNING_NUMBER_NOT_ENTERED = "당첨 번호를 입력해야 합니다.";
    private final Lotto winningNumbers;
    private final LottoNumber bonusBall;

    public LottoWinningNumber(final String input, int bonusBall) {
        validateEmpty(input);
        this.winningNumbers = parseWinningNumbers(input);
        this.bonusBall = new LottoNumber(bonusBall);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    private Lotto parseWinningNumbers(final String input) {
        try {
            List<LottoNumber> winningNumberList = Arrays.stream(input.split(WINNING_NUMBER_DELIMITER))
                    .map(String::strip)
                    .map(Integer::parseInt)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
            return new Lotto(winningNumberList);
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
