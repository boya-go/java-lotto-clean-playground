package controller;

import domain.LottoAmountCalculator;
import domain.LottoNumberGenerator;
import domain.LottoProfitCalculator;
import domain.LottoTicket;
import domain.LottoWinningNumber;
import domain.WinningStatistics;
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

        String winningLottoNumbers = InputView.enterLottoWinningNumber();
        LottoWinningNumber winningLotto = new LottoWinningNumber(winningLottoNumbers);
        WinningStatistics winningStatistics = new WinningStatistics(winningLotto, lottoTicket);
        double profitRate = LottoProfitCalculator.calculateProfit(winningStatistics, purchaseAmount);

        OutputView.printWinningStatistics(winningStatistics);
        OutputView.printProfitRate(profitRate);
    }
}
