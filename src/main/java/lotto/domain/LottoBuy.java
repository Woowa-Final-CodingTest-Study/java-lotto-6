package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.NumberConstant;

public class LottoBuy {

    public LottoNumbers gatherLottoNumbers(int lottoAmount) {
        List<Lotto> lottoNumbers = new ArrayList<>();

        for(int i=0; i<lottoAmount; i++) {
            lottoNumbers.add(generateLottoNumber());
        }

        LottoNumbers purchasedLotto =  new LottoNumbers(lottoNumbers);
        return purchasedLotto;
    }

    public Lotto generateLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(NumberConstant.MIN_NUMBER, NumberConstant.MAX_NUMBER, NumberConstant.LOTTO_SIZE));
        Lotto lotto = new Lotto(lottoNumbers);

        return lotto;
    }

    public int calculateLottoAmount(int purchaseAmount) {
        return purchaseAmount / NumberConstant.LOTTO_PRICE;
    }

}
