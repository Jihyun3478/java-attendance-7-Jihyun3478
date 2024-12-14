package attendance.view;

public class OutputView {
    public static void start() {
        System.out.println("오늘은 12월 13일 금요일입니다. 기능을 선택해 주세요.");
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

    public static void inputTime() {
        System.out.print("등교 시간을 입력해 주세요.");
    }

    public static void finishAttendanceTime() {
        System.out.print("12월 13일 금요일 09:59 (출석)");
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
    public static void attendaceRecord() {
        System.out.print("이번 달 빙티의 출석 기록입니다.\n"
            + "\n"
            + "12월 02일 월요일 13:00 (출석)\n"
            + "12월 03일 화요일 09:58 (출석)\n"
            + "12월 04일 수요일 10:02 (출석)\n"
            + "12월 05일 목요일 10:06 (지각)\n"
            + "12월 06일 금요일 10:01 (출석)\n"
            + "12월 09일 월요일 --:-- (결석)\n"
            + "12월 10일 화요일 10:08 (지각)\n"
            + "12월 11일 수요일 --:-- (결석)\n"
            + "12월 12일 목요일 --:-- (결석)\n"
            + "\n"
            + "출석: 4회\n"
            + "지각: 2회\n"
            + "결석: 3회\n"
            + "\n"
            + "면담 대상자입니다.");
    }

    /* 출석 기록 */
    public static void findAttendanceCrew() {
        System.out.print("제적 위험자 조회 결과\n"
            + "- 빙티: 결석 3회, 지각 2회 (면담)\n"
            + "- 이든: 결석 2회, 지각 4회 (면담)\n"
            + "- 쿠키: 결석 2회, 지각 2회 (경고)\n"
            + "- 빙봉: 결석 1회, 지각 5회 (경고)");
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}

