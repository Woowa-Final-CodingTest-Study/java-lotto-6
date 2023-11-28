package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    private final List<Lotto> lottos;

    public PurchasedLotto(int purchaseNumber) {
        lottos = new ArrayList<>();

        while (--purchaseNumber >= 0) {
            lottos.add(new Lotto());
        }
    }

    public List<String> getPurchasedLotto() {
        List<String> purchasedLotto = new ArrayList<>();
        for (Lotto lotto : lottos) {
            purchasedLotto.add(lotto.getLottoNumbersWithComma());
        }
        return purchasedLotto;
    }

    public List<WinningMatch> getWinningResult(WinningLotto winningLotto) {
        List<WinningMatch> winningResult = new ArrayList<>();
        for (Lotto lotto : lottos) {
            WinningMatch temp = winningLotto.calculateWinningMatch(lotto);
            if (temp != null) {
                winningResult.add(winningLotto.calculateWinningMatch(lotto));
            }
        }
        return winningResult;
    }
}
