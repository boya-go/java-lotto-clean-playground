package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountCalculatorTest {

    LottoAmountCalculator lottoAmountCalculator = new LottoAmountCalculator();

    @Nested
    @DisplayName("입력된 금액은 1000원 단위의 양의 정수여야 한다.")
    class puschasedAmountVaildateTest {

        @ParameterizedTest
        @ValueSource(ints = {0, -1, -1000})
        @DisplayName("입력값이 0 이하인 경우")
        void validatePurchaseAmount_입력값0이하_예외처리(int parchaseAmount) {

            assertThatThrownBy(() -> lottoAmountCalculator.CalculateLottoAmount(parchaseAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("금액은 0원보다 커야 합니다.");

        }

        @ParameterizedTest
        @ValueSource(ints= {999, 1001, 3300})
        @DisplayName("입력값이 천원 단위가 아닌 경우")
        void validatePurchaseAmount_입력값천원단위아님_예외처리(int parchaseAmount) {

            assertThatThrownBy((() -> lottoAmountCalculator.CalculateLottoAmount(parchaseAmount)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("금액은 1000원 단위로만 입력할 수 있습니다.");
        }
    }

    @Nested
    @DisplayName("정상적으로 가격이 입력되면 구매 매수를 반환한다.")
    class puchasedAmountTest {

        @ParameterizedTest
        @CsvSource({
                "1000, 1",
                "2000, 2",
                "10000000, 10000"
        })
        @DisplayName("구매 매수 테스트")
        void CalculateLottoAmount(int parchaseAmount, int expectedAmount) {

            assertThat(lottoAmountCalculator.CalculateLottoAmount(parchaseAmount))
                    .isEqualTo(expectedAmount);
        }
    }
}
