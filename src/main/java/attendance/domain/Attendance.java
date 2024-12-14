package attendance.domain;

public class Attendance {
    private final String nickname;
    private final String date;
    private String time;
    private final AttendanceType attendanceType;

    public Attendance(String nickname, String datetime, AttendanceType attendanceType) {
        this.nickname = nickname;
        String[] splitDateTime = datetime.split(" ");
        this.date = splitDateTime[0];
        this.time = splitDateTime[1];
        this.attendanceType = attendanceType;
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

    public void modifyTime(String time) {
        this.time = time;
    }

    public AttendanceType getAttendanceType() {
        return attendanceType;
    }
}
