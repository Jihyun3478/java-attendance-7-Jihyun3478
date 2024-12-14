package attendance.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import camp.nextstep.edu.missionutils.DateTimes;

public class CurrentDay {
    private int day;
    private String dayOfWeek;

    public CurrentDay() {
        this.day = setUp();
        this.dayOfWeek = Calendar.dayOfWeekByDay(setUp());
    }

    public int setUp() {
        LocalDateTime now = DateTimes.now();
        String nowDay = now.format(DateTimeFormatter.ofPattern("dd"));
        return Integer.parseInt(checkNowDay(nowDay));
    }

    private String checkNowDay(String nowDay) {
        if(String.valueOf(nowDay.charAt(0)).equals("0")) {
            return String.valueOf(nowDay.charAt(1));
        }
        return nowDay;
    }

    public int getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
