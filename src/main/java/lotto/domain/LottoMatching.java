package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Rank;

public class LottoMatching {

    public int matchingLottoNumbers(List<Integer> lottoNumber, List<Integer> winningNumbers) {
        int matchingCount = 0;
        for(int winningNumber : winningNumbers) {
            if(lottoNumber.contains(winningNumber)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    public boolean matchingBonusNumber(List<Integer> lottoNumber, int bonusNumber) {
        if(lottoNumber.contains(bonusNumber)) {
            return true;
        }
        return false;
    }




}
