package attendance.domain;

import static attendance.exception.ErrorMessage.*;

import java.util.List;

public class Attendances {
    private final List<Attendance> attendances;

    public Attendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void add(String nickname, int currentDay, String time) {
        attendances.add(new Attendance(nickname, "2024-12-" + currentDay + " " + time, AttendanceType.출석));
    }

    public boolean isRegisterCrew(String nickname) {
        boolean isRegister = attendances.stream()
            .anyMatch(attendance -> attendance.getNickname().equals(nickname));

        if(!isRegister) {
            throw new IllegalArgumentException(NOT_EXIST_NICKNAME.getMessage());
        }
        return true;
    }

    public boolean alreadyAttendance(String nickname, int day) {
        for(Attendance attendance : attendances) {
            if(attendance.getNickname().equals(nickname) && attendance.getDate().contains(String.valueOf(day))) {
                throw new IllegalArgumentException(ALREADY_ATTENDANCE.getMessage());
            }
        }
        return true;
    }
}
