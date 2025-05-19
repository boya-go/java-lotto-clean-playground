package domain;

import java.util.List;

public class LottoNumbers {

    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String OUT_OF_LOTTO_NUMBER = "로또 번호는 1부터 45 사이어야 합니다.";
    private static final String OUT_OF_LOTTO_NUMBER_COUNT = "로또 번호는 6개이어야 합니다.";

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = List.copyOf(lottoNumbers);
    }

    private void validate(List<Integer> lottoNumbers) {
        if (!lottoNumbers.stream().allMatch(number -> number >= LOTTO_MINIMUM_NUMBER && number <= LOTTO_MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER);
        }
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER_COUNT);
        }
    }

    public List<Integer> lottoNumbersToList() {
        return List.copyOf(lottoNumbers);
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    public int matchCount(LottoNumbers other) {
        return (int)lottoNumbers.stream()
                .filter(other::contains)
                .count();
    }

}