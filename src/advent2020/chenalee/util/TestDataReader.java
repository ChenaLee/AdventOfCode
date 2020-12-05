package advent2020.chenalee.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TestDataReader {
    private static String dataFolderPath = "src/advent2020/chenalee/data/";

    public static List<String> readAllLines(String fileName) throws IOException {
        return Files.readAllLines(getPath(fileName));
    }

    public static Scanner getScannerForFile(String fileName, String regexDelimiter) throws IOException {
        Scanner scanner = new Scanner(getPath(fileName));
        scanner.useDelimiter(regexDelimiter);
        return scanner;
    }

    private static Path getPath(String fileName) {
        return Paths.get(dataFolderPath + fileName);
    }
}
