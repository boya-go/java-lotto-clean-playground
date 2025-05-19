package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lotto generate() {

        List<Integer> numbers = generateNumberPool();
        Collections.shuffle(numbers);

        List<LottoNumber> selectedNumbers = numbers.subList(0, LOTTO_NUMBER_COUNT).stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new Lotto(selectedNumbers);
    }

    private List<Integer> generateNumberPool() {
        return IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
