package attendance.domain;

public class Attendance {
    private final String nickname;
    private final String date;
    private final String time;
    private AttendanceType attendanceType;

    public Attendance(String nickname, String datetime) {
        this.nickname = nickname;
        String[] splitDateTime = datetime.split(" ");
        this.date = splitDateTime[0];
        this.time = splitDateTime[1];
    }

    public String getNickname() {
        return nickname;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
