package attendance.service;

import java.io.File;
import java.util.List;

import attendance.domain.Attendance;
import attendance.domain.Attendances;
import attendance.util.FileReader;
import attendance.util.Parser;

public class FileService {
    private static final String FILE_PATH = "src/main/resources/attendances.csv";

    public static Attendances createAttendances() {
        List<String> lines = FileReader.readFile(new File(FILE_PATH));
        List<Attendance> attendances = Parser.parseAttendance(lines);
        return new Attendances(attendances);
    }
}
