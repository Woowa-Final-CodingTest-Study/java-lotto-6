package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public List<String> toStringList() {
        return lottoBundle.stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
    }

    public int count() {
        return lottoBundle.size();
    }

    public List<LottoRank> ranks(Lotto winningLotto, int bonusNumber) {
        return lottoBundle.stream()
                .map(lotto -> lotto.rank(winningLotto, bonusNumber))
                .toList();
    }
}
