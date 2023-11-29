package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    void name() {
        LottoRank lottoRank = new LottoRank();

        Map<String, Integer> result = lottoRank.initializeRank();
        Map<String, Integer> answer = new HashMap<>();

        answer.put("FIFTH", 0);
        answer.put("FORTH", 0);
        answer.put("THIRD", 0);
        answer.put("SECOND", 0);
        answer.put("FIRST", 0);

        assertThat(result).usingRecursiveComparison().isEqualTo(answer);
    }
}