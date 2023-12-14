package lotto.constant;

public enum SystemMessage {

    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_LOTTO("%d개를 구매했습니다."),
    INPUT_WIN_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WIN_RESULT("""
            당첨 통계
            ---
            """),
    PROFIT("총 수익률은 %.d%%입니다.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
