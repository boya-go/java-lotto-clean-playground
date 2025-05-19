package domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void matchCountOf_정상입력시_해당하는Rank반환() {

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(Rank.matchCountOf(3)).isEqualTo(Rank.THREE);
        softly.assertThat(Rank.matchCountOf(4)).isEqualTo(Rank.FOUR);
        softly.assertThat(Rank.matchCountOf(5)).isEqualTo(Rank.FIVE);
        softly.assertThat(Rank.matchCountOf(6)).isEqualTo(Rank.ALL);

        softly.assertAll();
    }

    @Test
    void matchCountOf_prize가없는일치개수의경우_NONE반환() {

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(Rank.matchCountOf(0)).isEqualTo(Rank.NONE);
        softly.assertThat(Rank.matchCountOf(1)).isEqualTo(Rank.NONE);
        softly.assertThat(Rank.matchCountOf(2)).isEqualTo(Rank.NONE);

        softly.assertAll();
    }
}
