package attendance.domain;

public enum EducationTime {
    월요일("월요일", 13, 18),
    화요일("화요일", 10, 18),
    수요일("수요일", 10, 18),
    목요일("목요일", 10, 18),
    금요일("금요일", 10, 18),
    ;

    private final String dayOfWeek;
    private final int startTime;
    private final int endTime;

    EducationTime(String dayOfWeek, int startTime, int endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
