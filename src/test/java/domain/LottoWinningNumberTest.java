package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoWinningNumberTest {

    @Nested
    @DisplayName("입력된 지난 당첨번호를 정상적으로 로또 객체로 생성한다.")
    class createLottoWinningNumber {

        @Test
        void LottoWinningNumber_입력된당첨번호로_로또객체생성() {
            String input = "1,2,3,4,5,6";

            LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(input);

            assertThat(lottoWinningNumber.getWinningNumbers())
                    .isNotNull()
                    .extracting("lottoNumbers")
                    .asList()
                    .containsExactly(1, 2, 3, 4, 5, 6);
        }
    }

    @Nested
    @DisplayName("입력된 당첨번호는 로또 번호와 같은 예외처리를 한다.")
    class validateLottoWinningNumber {

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
        void LottoWinningNumber_입력된로또번호6개가아닐시_예외처리(String input) {

            assertThatThrownBy(() -> new LottoWinningNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("로또 번호는 6개이어야 합니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"0,1,2,3,4,5", "41,42,43,44,45,46","-2,-1,0,1,2,3"})
        void LottoWinningNumber_입력된로또번호가범위를벗어날시_예외처리(String input) {

            assertThatThrownBy(() -> new LottoWinningNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("로또 번호는 1부터 45 사이어야 합니다.");
        }
    }

    @Nested
    @DisplayName("입력값 검증하여 예외처리를 한다.")
    class validateInput {

        @ParameterizedTest
        @ValueSource(strings = {" ",""})
        void LottoWinningNumber_입력값이없을때_예외처리(String input) {
            assertThatThrownBy(() -> new LottoWinningNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("당첨 번호를 입력해야 합니다.");
        }

        @Test
        void LottoWinningNumber_입력값이null일때_예외처리() {

            String input = null;
            assertThatThrownBy(() -> new LottoWinningNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("당첨 번호를 입력해야 합니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,당첨", "ㄱ,ㄴ,ㄷ,ㄹ,ㅁ,ㅂ","1,2,3,,5,6"})
        void LottoWinningNumber_입력값에숫자아닌값이포함되어있을때_예외처리(String input) {
            assertThatThrownBy(() -> new LottoWinningNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자만 입력할 수 있습니다.");
        }
    }
}
