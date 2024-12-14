package attendance.domain;

import static attendance.exception.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

public class Attendances {
    private final List<Attendance> attendances;

    public Attendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public List<Attendance> getAttendancesByNickname(String nickname) {
        List<Attendance> attendancesByNickname = new ArrayList<>();
        for(Attendance attendance : attendances) {
            if(attendance.getNickname().equals(nickname)) {
                attendancesByNickname.add(attendance);
            }
        }
        return attendancesByNickname;
    }

    public Attendance getAttendanceByNickname(String currentDate, String nickname) {
        for(Attendance attendance : attendances) {
            String date = attendance.getDate();
            if(attendance.getNickname().equals(nickname) && date.equals(currentDate)) {
                return attendance;
            }
        }
        throw new IllegalArgumentException(NOT_EXIST_NICKNAME.getMessage());
    }

    public void add(String nickname, int currentDay, String time, String dayOfWeek) {
        int startTime = EducationTime.startTimeByDayOfWeek(dayOfWeek);
        String[] splitTime = getSplitTime(time);
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);

        AttendanceType attendanceType = null;
        if(startTime <= hour && minute > 5) {
            attendanceType = AttendanceType.지각;
        }
        if(startTime <= hour && minute > 30) {
            attendanceType = AttendanceType.결석;
        }
        attendances.add(new Attendance(nickname, "2024-12-" + currentDay + " " + time, attendanceType));
    }

    private static String[] getSplitTime(String time) {
        return time.split(":");
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
