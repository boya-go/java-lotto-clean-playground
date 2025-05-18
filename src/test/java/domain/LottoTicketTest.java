package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    LottoAmountCalculator lottoAmountCalculator = new LottoAmountCalculator();

    @Test
    @DisplayName("구매한만큼의 로또 개수를 반환한다,")
    void LottoTicket_입력한가격에대응되는_로또개수반환() {

        LottoTicket lottoTicket = new LottoTicket(3000, lottoAmountCalculator, lottoNumberGenerator);

        assertThat(lottoTicket.getTicketSize()).isEqualTo(3);
    }



}
