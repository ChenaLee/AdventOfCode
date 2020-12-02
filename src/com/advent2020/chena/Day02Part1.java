package com.advent2020.chena;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day02Part1 {

    private static class PasswordPolicy {
        private int minCount;
        private int maxCount;
        private char requiredCharacter;

        private PasswordPolicy(int minCount, int maxCount, char requiredCharacter) {
            this.minCount = minCount;
            this.maxCount = maxCount;
            this.requiredCharacter = requiredCharacter;
        }

        private boolean validatePassword(String password) {
            int count = countGivenCharacter(password, this.requiredCharacter);
            return count >= this.minCount && count <= this.maxCount;
        }

        private int countGivenCharacter(String string, char givenCharacter) {
            int count = 0;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == givenCharacter) {
                    count++;
                }
            }
            return count;
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
