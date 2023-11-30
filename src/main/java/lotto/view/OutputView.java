package lotto.view;

import lotto.constant.OutputMessage;
import lotto.model.LottoBundle;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void notifyInputAmount() {
        println(OutputMessage.NOTIFY_INPUT_AMOUNT);
    }

    public void printGeneratedLottoResults(LottoBundle lottoBundle) {
        println(lottoBundle.count() + OutputMessage.PRINT_LOTTO_COUNT_SUFFIX);
        lottoBundle.toStringList().forEach(this::println);
    }
}
