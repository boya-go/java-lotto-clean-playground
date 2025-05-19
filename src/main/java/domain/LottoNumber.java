package domain;

import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final String OUT_OF_LOTTO_NUMBER = "로또 번호는 1부터 45 사이어야 합니다.";

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (!(number >= LOTTO_MINIMUM_NUMBER && number <= LOTTO_MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER);
        }
    }

    public int getLottoNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
