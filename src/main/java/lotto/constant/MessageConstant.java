package lotto.constant;

public class MessageConstant {
    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String PURCHASED_LOTTO_AMOUNT = "\n%d개를 구매했습니다.\n";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해주세요.";
    public static final String STATISTICS = """
            \n당첨 통계
            ---
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개
            """;
    public static final String TOTAL_PROFIT = "총 수익률은 %s%%입니다.";
}
