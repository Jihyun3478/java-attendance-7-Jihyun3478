package attendance.service;

import attendance.domain.Attendance;
import attendance.domain.Attendances;

public class AttendanceService {
    private Attendances attendances;

    public Attendances check(String nickname, String time, Attendances attendances, int currentDay) {
        if(isRegisterCrew(nickname, attendances) && !alreadyAttendance(nickname, currentDay, attendances)) {
            attendances.getAttendances().add(new Attendance(nickname, "2024-12-" + currentDay + " " + time));
        }
        this.attendances = attendances;
        return attendances;
    }

    private boolean isRegisterCrew(String nickname, Attendances attendances) {
        return attendances.isRegisterCrew(nickname);
    }

    private boolean alreadyAttendance(String nickname, int currentDay, Attendances attendances) {
        return attendances.alreadyAttendance(nickname, currentDay);
    }
}
