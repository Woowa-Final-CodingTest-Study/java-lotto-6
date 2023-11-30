package lotto.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final HashMap<LottoRank, Long> results;
    private final float earningRatio;

    public WinningResult(HashMap<LottoRank, Long> results, float earningRatio) {
        this.results = results;
        this.earningRatio = earningRatio;
    }

    public List<String> toResultStrings() {
        List<String> strings = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("###,###");
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.LOSE)
                continue;
            Long count = results.get(rank);
            StringBuilder sb = new StringBuilder();
            sb.append(rank.matchCount);
            sb.append("개 일치");
            if(rank.isBonusMatched)
                sb.append(", 보너스 볼 일치");
            sb.append(" (");
            sb.append(df.format(rank.prize));
            sb.append("원) - ");
            sb.append(count);
            sb.append("개");
            strings.add(sb.toString());
        }
        return strings;
    }

    public String toEarningRatioString() {
        return String.format("%.1f", earningRatio*100);
    }
}
