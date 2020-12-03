package advent2020.chenalee.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestDataReader {
    private static String dataFolderPath = "src/advent2020/chenalee/data/";

    public static List<String> readAllLines(String fileName) throws IOException {
        return Files.readAllLines(getPath(fileName));
    }

    private static Path getPath(String fileName) {
        return Paths.get(dataFolderPath + fileName);
    }
}
