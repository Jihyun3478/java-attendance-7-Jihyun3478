package attendance.exception;

public enum ErrorMessage {
    NON_EXIST_FILE("존재하지 않는 파일입니다."),
    NOT_EXIST_NICKNAME("등록되지 않은 닉네임입니다."),
    CANT_GO_CAMPUS("12월 %d일 %s은 등교일이 아닙니다."),
    ALREADY_ATTENDANCE("이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요."),
    INVALID_FORMAT("잘못된 형식을 입력하였습니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private static final String POSTFIX = " 다시 입력해 주세요.";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(PREFIX + message, args);
    }
}
