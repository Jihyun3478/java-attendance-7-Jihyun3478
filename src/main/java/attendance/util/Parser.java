package attendance.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import attendance.domain.Attendance;
import attendance.domain.AttendanceType;

public class Parser {
	public static List<Attendance> parseAttendance(List<String> lines) {
		return lines.stream()
			.skip(1)
			.map(Parser::parseAttendanceLine)
			.collect(Collectors.toList());
	}

	private static Attendance parseAttendanceLine(String line) {
		List<String> columns = parseLine(line);
		String nickname = columns.get(0);
		String datetime = columns.get(1);

		return new Attendance(nickname, datetime, AttendanceType.출석);
	}

	private static List<String> parseLine(String line) {
		return Arrays.asList(line.split(","));
	}
}
