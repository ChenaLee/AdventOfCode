package advent2020.chenalee.day02;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Day02Part1 {

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        List<String> passwordRecordStrings = TestDataReader.readAllLines("day02.txt");
        List<PasswordRecord> passwordRecords = PasswordRecordParser.parsePasswordRecords(passwordRecordStrings, MinMaxPasswordPolicy.class);
        int validPasswordCount = 0;

        for (PasswordRecord record : passwordRecords) {
            if (record.getPasswordPolicy().validatePassword(record.getPassword())) {
                validPasswordCount++;
            }
        }
        System.out.println(validPasswordCount);
    }
}
