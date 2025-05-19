package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String OUT_OF_LOTTO_NUMBER_COUNT = "로또 번호는 6개이어야 합니다.";

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER_COUNT);
        }
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto other) {
        return (int) numbers.stream()
                .filter(other::contains)
                .count();
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
