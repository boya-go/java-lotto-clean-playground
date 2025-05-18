package domain;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @Test
    @DisplayName("로또번호는 0에서 45 사이 숫자들로 구성된다.")
    void generate_숫자범위테스트() {

        // given
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        assertThat(lottoNumbers)
                .allSatisfy(number -> {
                    assertThat(number)
                            .isBetween(0, 45);
                });
    }

    @Test
    @DisplayName("로또번호는 6가지 숫자로 구성된다.")
    void generate_숫자개수테스트() {

        // given
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    @DisplayName("로또번호는 정렬되어 있다.")
    void generate_숫자정렬여부테스트() {

        // given
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        assertThat(lottoNumbers).isSorted();
    }
}
