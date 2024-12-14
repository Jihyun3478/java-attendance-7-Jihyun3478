package attendance.exception;

public enum ErrorMessage {
    NON_EXIST_FILE("존재하지 않는 파일입니다."),
    INVALID_COUNT(""),
    ;

    private static final String PREFIX = "[ERROR] ";
    private static final String POSTFIX = " 다시 입력해 주세요.";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(PREFIX + message + POSTFIX, args);
    }
}
