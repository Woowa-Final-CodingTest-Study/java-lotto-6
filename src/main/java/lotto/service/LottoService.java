package lotto.service;

import static lotto.constant.NumberConstant.MAX_LOTTO_COUNT;
import static lotto.constant.NumberConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.NumberConstant.MIN_LOTTO_NUMBER;
import static lotto.constant.NumberConstant.PURCHASE_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class LottoService {

    LottoRepository lottoRepository = new LottoRepository();

    public void generateLottoNumbers(int purchaseAmount) {
        while (purchaseAmount-- > 0) {
            Lotto lotto = new Lotto(createLottoNumbers());
            lottoRepository.saveLotto(lotto);
        }
    }

    public List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(),
                MAX_LOTTO_NUMBER.getValue(), MAX_LOTTO_COUNT.getValue());
        Collections.sort(numbers);
        return numbers;
    }

    public StringBuilder getLottoNumbers() {
        StringBuilder sb = new StringBuilder();
        List<Lotto> lottos = lottoRepository.getLotto();

        for(Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            sb.append("[")
                    .append(numbers.stream().map(Object::toString).collect(Collectors.joining(", ")))
                    .append("]")
                    .append("\n");
        }
        return sb;
    }
}
