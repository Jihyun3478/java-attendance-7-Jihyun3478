package attendance.view;

import java.util.List;

import attendance.domain.Attendance;
import attendance.domain.AttendanceType;
import attendance.domain.Attendances;

public class OutputView {
    public static void start(int day, String dayOfWeek) {
        System.out.println("오늘은 12월 " + day + "일 " + dayOfWeek + "입니다. 기능을 선택해 주세요.");
        System.out.println("1. 출석 확인\n"
            + "2. 출석 수정\n"
            + "3. 크루별 출석 기록 확인\n"
            + "4. 제적 위험자 확인\n"
            + "Q. 종료");
    }

    /* 출석 확인 */
    public static void inputNickname() {
        System.out.println("닉네임을 입력해 주세요.");
    }

    public static void inputGoTime() {
        System.out.print("등교 시간을 입력해 주세요.");
    }

    public static void finishAttendanceTime(int day, String dayOfWeek, String time) {
        System.out.printf("12월 %d일 %s %s (출석)", day, dayOfWeek, time);
        System.out.println();

    }

    /* 출석 수정 */
    public static void inputModifyAttendanceNickname() {
        System.out.print("출석을 수정하려는 크루의 닉네임을 입력해 주세요.");
    }

    public static void inputModifyDate() {
        System.out.println("수정하려는 날짜(일)를 입력해 주세요.");
    }

    public static void inputWhenModify() {
        System.out.print("언제로 변경하겠습니까?");
    }

    public static void finishModifyTime() {
        System.out.print("12월 03일 화요일 10:07 (지각) -> 09:58 (출석) 수정 완료!");
    }

    /* 출석 기록 */
    public static void attendanceRecord(List<Attendance> attendancesByNickname, String nickname) {
        System.out.printf("%n이번 달 %s의 출석 기록입니다.%n", nickname);
        for(Attendance attendance : attendancesByNickname) {
            String date = attendance.getDate();
            String time = attendance.getTime();
            String attendanceType = String.valueOf(attendance.getAttendanceType());
            System.out.printf("%s %s (%s) %n", date, time, attendanceType);
        }
        System.out.println();
    }

    /* 제적 위험자 조회 */
    public static void findAttendanceCrew() {
        System.out.print("제적 위험자 조회 결과\n"
            + "- 빙티: 결석 3회, 지각 2회 (면담)\n"
            + "- 이든: 결석 2회, 지각 4회 (면담)\n"
            + "- 쿠키: 결석 2회, 지각 2회 (경고)\n"
            + "- 빙봉: 결석 1회, 지각 5회 (경고)");
    }
}

