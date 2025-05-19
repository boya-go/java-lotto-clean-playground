package domain;

public class LottoAmountCalculator {

    private static final int LOTTO_PRICE = 1000;
    private static final String AMOUNT_MUST_BE_POSITIVE = "금액은 0원보다 커야 합니다.";
    private static final String AMOUNT_MUST_BE_IN_THOUSANDS = "금액은 1000원 단위로만 입력할 수 있습니다.";

    public int calculateLottoAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount/LOTTO_PRICE;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0){
            throw new IllegalArgumentException(AMOUNT_MUST_BE_POSITIVE);
        }
        if (purchaseAmount % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(AMOUNT_MUST_BE_IN_THOUSANDS);
        }
    }
}
