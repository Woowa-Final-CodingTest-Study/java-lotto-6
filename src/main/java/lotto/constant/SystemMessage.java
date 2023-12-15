package lotto.constant;

public enum SystemMessage {

    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_LOTTO("\n%d개를 구매했습니다."),
    INPUT_WIN_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    WIN_RESULT("""
            \n당첨 통계
            ---"""),
    MATCH_RESULT("%d개 일치 (%,d원) - %d개"),
    MATCH_BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    PROFIT("총 수익률은 %s%%입니다.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
