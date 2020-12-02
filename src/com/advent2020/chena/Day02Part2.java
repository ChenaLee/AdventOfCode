package com.advent2020.chena;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day02Part2 {

    private static class PasswordPolicy {
        private int position1;
        private int position2;
        private char requiredCharacter;

        private PasswordPolicy(int position1, int position2, char requiredCharacter) {
            this.position1 = position1;
            this.position2 = position2;
            this.requiredCharacter = requiredCharacter;
        }

        private boolean validatePassword(String password) {
            int matchedPositionCount = 0;
            if (password.charAt(this.position1 - 1) == this.requiredCharacter) {
                matchedPositionCount++;
            }
            if (password.charAt(this.position2 - 1) == this.requiredCharacter) {
                matchedPositionCount++;
            }
            return matchedPositionCount == 1;
        }
    }

    private static class PasswordRecord {
        private PasswordPolicy passwordPolicy;
        private String password;

        private PasswordRecord(PasswordPolicy passwordPolicy, String password) {
            this.passwordPolicy = passwordPolicy;
            this.password = password;
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> passwordRecordStrings = Files.readAllLines(Paths.get("src/com/advent2020/chena/data/day02.txt"));
        List<PasswordRecord> passwordRecords = parsePasswordRecords(passwordRecordStrings);
        int validPasswordCount = 0;

        for (PasswordRecord record : passwordRecords) {
            if (record.passwordPolicy.validatePassword(record.password)) {
                validPasswordCount++;
            }
        }
        System.out.println(validPasswordCount);
    }

    private static List<PasswordRecord> parsePasswordRecords(List<String> passwordRecordStrings) {
        List<PasswordRecord> passwordRecords = new ArrayList<>();
        for (String passwordRecordString : passwordRecordStrings) {
            String[] parsedPasswordRecord = passwordRecordString.split("([- :])");
            int minCount = Integer.parseInt(parsedPasswordRecord[0]);
            int maxCount = Integer.parseInt(parsedPasswordRecord[1]);
            char requiredCharacter = parsedPasswordRecord[2].charAt(0);
            PasswordPolicy policy = new PasswordPolicy(minCount, maxCount, requiredCharacter);
            PasswordRecord record = new PasswordRecord(policy, parsedPasswordRecord[4]);
            passwordRecords.add(record);
        }
        return passwordRecords;
    }
}
