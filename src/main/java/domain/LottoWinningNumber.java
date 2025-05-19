package domain;

import java.util.Arrays;
import java.util.List;

public class LottoWinningNumber {

    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String WINNING_NUMBER_MUST_BE_A_NUMBER = "숫자만 입력할 수 있습니다.";
    private static final String WINNING_NUMBER_NOT_ENTERED = "당첨 번호를 입력해야 합니다.";
    private static final int BONUS_MINIMUM_NUMBER = 1;
    private static final int BONUS_MAXIMUM_NUMBER = 45;
    private static final String OUT_OF_BONUS_NUMBER = "보너스볼 숫자는 1부터 45 사이어야 합니다.";
    private final LottoNumbers winningNumbers;
    private final int bonusBall;

    public LottoWinningNumber(final String input, int bonusBall) {
        validateEmpty(input);
        this.winningNumbers = new LottoNumbers(parseWinningNumbers(input));
        validateBonusNumber(bonusBall);
        this.bonusBall = bonusBall;
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
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

    private void validateBonusNumber(final int bonusNumber) {
        if (!(bonusNumber >= BONUS_MINIMUM_NUMBER && bonusNumber <= BONUS_MAXIMUM_NUMBER)) {
                throw new IllegalArgumentException(OUT_OF_BONUS_NUMBER);
            }
    }
}
