package attendance.domain;

public class Attendance {
    private final String nickname;
    private final String datetime;

    public Attendance(String nickname, String datetime) {
        this.nickname = nickname;
        this.datetime = datetime;
    }
}
