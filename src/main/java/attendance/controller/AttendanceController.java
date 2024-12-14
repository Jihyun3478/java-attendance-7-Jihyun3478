package attendance.controller;

import static attendance.exception.ErrorMessage.*;

import java.util.List;

import attendance.domain.Attendance;
import attendance.domain.Attendances;
import attendance.domain.Calendar;
import attendance.domain.CurrentDay;
import attendance.service.AttendanceService;
import attendance.service.FileService;
import attendance.view.InputView;
import attendance.view.OutputView;

public class AttendanceController {

    private Attendances attendances = FileService.createAttendances();
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    public void run() {

        CurrentDay currentDay = new CurrentDay();
        int day = currentDay.getDay();
        String dayOfWeek = currentDay.getDayOfWeek();

        String chooseFunction = "";

        while (!chooseFunction.equals("Q")) {
            OutputView.start(day, dayOfWeek);
            chooseFunction = InputView.chooseFunction();
            // TODO: 5가 아닌 day로 수정
            Calendar.isHoliday(day, dayOfWeek);

            if (chooseFunction.equals("1")) {
                checkAttendance(day, dayOfWeek);
            }
            if (chooseFunction.equals("2")) {
                modifyAttendance();
            }
            if (chooseFunction.equals("3")) {
                recordAttendance();
            }
            if (chooseFunction.equals("4")) {
                dangerAttendance();
            }
        }
    }

    private void checkAttendance(int day, String dayOfWeek) {
        /* 출석 확인 */
        OutputView.inputNickname();
        String nickname = InputView.nickname();
        attendanceService.isRegisterCrew(nickname, attendances);
        OutputView.inputGoTime();
        String time = InputView.goTime();
        String[] splitTime = time.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[0]);
        if(hour > 24 || minute > 60) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }

        this.attendances = attendanceService.check(nickname, time, attendances, day, dayOfWeek);

        OutputView.finishAttendanceTime(day, dayOfWeek, time);
    }

    private void modifyAttendance() {
        /* 출석 수정 */
        OutputView.inputModifyAttendanceNickname();
        String modifyTargetNickname = InputView.nickname();
        OutputView.inputModifyDate();
        String modifyDate = InputView.modifyDate();
        OutputView.inputWhenModify();
        String modifyTime = InputView.modifyTime();
        OutputView.finishModifyTime();


    }

    private void recordAttendance() {
        /* 출석 기록 */
        OutputView.inputNickname();
        String nickname = InputView.nickname();
        List<Attendance> attendancesByNickname = attendanceService.attendancesByNickname(attendances, nickname);
        OutputView.attendanceRecord(attendancesByNickname, nickname);
    }

    private void dangerAttendance() {
        /* 제적 위험자 조회 */
        OutputView.findAttendanceCrew();
    }
}
