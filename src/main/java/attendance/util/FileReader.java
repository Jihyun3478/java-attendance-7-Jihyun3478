package attendance.util;

import static attendance.exception.ErrorMessage.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<String> readFile(File file) {
        List<String> fileLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                fileLines.add(fileLine);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(NON_EXIST_FILE.getMessage());
        }
        return fileLines;
    }
}
