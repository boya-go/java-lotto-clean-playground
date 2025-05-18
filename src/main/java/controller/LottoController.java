package controller;

import domain.LottoAmountCalculator;
import domain.LottoNumberGenerator;
import domain.LottoTicket;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final LottoAmountCalculator calculator = new LottoAmountCalculator();
    private final LottoNumberGenerator generator = new LottoNumberGenerator();

    public void runLotto() {
        int purchaseAmount = InputView.enterLottoPuchase();
        LottoTicket lottoTicket = new LottoTicket(purchaseAmount, calculator, generator);

        OutputView.printPurchasedLottoAmount(lottoTicket.getTicketSize());
        OutputView.printLottoTicket(lottoTicket.getTicket());
    }
}
