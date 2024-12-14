package attendance.service;

import java.util.List;

import attendance.domain.Attendance;
import attendance.domain.Attendances;

public class AttendanceService {
    private Attendances attendances;

    public Attendances check(String nickname, String time, Attendances attendances, int currentDay, String dayOfWeek) {
        if (isRegisterCrew(nickname, attendances) && !alreadyAttendance(nickname, currentDay, attendances)) {
            attendances.add(nickname, currentDay, time, dayOfWeek);
        }
        this.attendances = attendances;
        return attendances;
    }

    public List<Attendance> attendancesByNickname(Attendances attendances, String nickname) {
        return attendances.getAttendancesByNickname(nickname);
    }

    public boolean isRegisterCrew(String nickname, Attendances attendances) {
        return attendances.isRegisterCrew(nickname);
    }

    private boolean alreadyAttendance(String nickname, int currentDay, Attendances attendances) {
        return attendances.alreadyAttendance(nickname, currentDay);
    }
}
