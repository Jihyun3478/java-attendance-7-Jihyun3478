package attendance.domain;

import static attendance.exception.ErrorMessage.*;

public enum Calendar {
    _1(1, "일요일", true),
    _2(2, "월요일", false),
    _3(3, "화요일", false),
    _4(4, "수요일", false),
    _5(5, "목요일", false),
    _6(6, "금요일", false),
    _7(7, "토요일", true),
    _8(8, "일요일", true),
    _9(9, "월요일", false),
    _10(10, "화요일", false),
    _11(11, "수요일", false),
    _12(12, "목요일", false),
    _13(13, "금요일", false),
    _14(14, "토요일", true),
    _15(15, "일요일", true),
    _16(16, "월요일", false),
    _17(17, "화요일", false),
    _18(18, "수요일", false),
    _19(19, "목요일", false),
    _20(20, "금요일", false),
    _21(21, "토요일", true),
    _22(22, "일요일", true),
    _23(23, "월요일", false),
    _24(24, "화요일", false),
    _25(25, "수요일", false),
    _26(26, "목요일", false),
    _27(27, "금요일", false),
    _28(28, "토요일", true),
    _29(29, "일요일", true),
    _30(30, "월요일", false),
    _31(31, "화요일", false),
    ;

    private final int day;
    private final String dayOfWeek;
    private final boolean isWeekend;

    Calendar(int day, String dayOfWeek, boolean isWeekend) {
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.isWeekend = isWeekend;
    }

    public int getDay() {
        return day;
    }

    public static boolean isWeekend(int day, String dayOfWeek) {
        for(Calendar calendar : Calendar.values()) {
            if(calendar.getDay() == day) {
                if(calendar.dayOfWeek.equals("토요일") || calendar.dayOfWeek.equals("일요일")) {
                    throw new IllegalArgumentException(CANT_GO_CAMPUS.getMessage(day, dayOfWeek));
                }
            }
        }
        return false;
    }

    public static String dayOfWeekByDay(int day) {
        for(Calendar calendar : Calendar.values()) {
            if(calendar.getDay() == day) {
                return calendar.dayOfWeek;
            }
        }
        throw new IllegalArgumentException("올바르지 않읂 형식의 날짜입니다.");
    }
}
