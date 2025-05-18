package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final List<Lotto> ticket;

    public LottoTicket(int purchaseAmount, LottoAmountCalculator calculator, LottoNumberGenerator generator) {
        int count = calculator.CalculateLottoAmount(purchaseAmount);
        this.ticket = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(generator.generate()))
                .collect(Collectors.toList());
    }

    public List<Lotto> getTicket() {
        return List.copyOf(ticket);
    }

    public int getTicketSize() {
        return ticket.size();
    }
}
