package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

public class OutputView {

    public void displayLottoPurchasePrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void displayPurchasedLottoAmount(LottoNumbers lottoNumbers) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoNumbers.getSize());
        printPurchasedLottoNumbers2(lottoNumbers);
    }

    public void printPurchasedLottoNumbers2(LottoNumbers lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lottoNumbers.getSize(); i++) {
            Lotto lotto = lottoNumbers.getEachLotto(i);
            sb.append("[").append(printPurchasedLottoNumbers(lotto)).append("]").append("\n");
        }

        System.out.println(sb);
    }

    public String printPurchasedLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getEachLottoNumbers();

        return String.join(", ", numbers.stream().map(String::valueOf).toArray(String[]::new));
    }
}
