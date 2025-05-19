package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final List<Lotto> ticket;

    public LottoTicket(int purchaseAmount, LottoAmountCalculator calculator, LottoNumberGenerator generator) {
        int count = calculator.calculateLottoAmount(purchaseAmount);
        this.ticket = createTicket(count, generator);
    }

    private List<Lotto> createTicket(int count, LottoNumberGenerator generator) {
        return IntStream.range(0, count)
                .mapToObj(i -> generator.generate())
                .collect(Collectors.toList());
    }

    public List<Lotto> getTicket() {
        return List.copyOf(ticket);
    }

    public int getTicketSize() {
        return ticket.size();
    }
}
