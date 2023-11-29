package lotto.utils;

public enum GameMessage {
    REQUEST_INPUT_MONEY("구입금액을 입력해 주세요."),
    REQUEST_BONUS_INPUT("보너스 번호를 입력해 주세요."),
    REQUEST_WINNING_NUMBERS_INPUT("당첨 번호를 입력해 주세요."),
    EARNING_RATE("총 수익률은 %.2f%%입니다.\n"),
    PRIZE_MONEY("%,d"),
    WINNING_STATISTICS("%d개 일치 (%s원) - %d개\n");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }


}
