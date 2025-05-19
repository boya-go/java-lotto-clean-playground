package domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getNumbersAsList() {
        return lottoNumbers.lottoNumbersToList();
    }

    public int matchCountWinnings(LottoNumbers winningNumbers) {
        return lottoNumbers.matchCount(winningNumbers);
    }
}
