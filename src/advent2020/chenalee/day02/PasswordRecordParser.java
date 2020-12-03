package advent2020.chenalee.day02;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

class PasswordRecordParser {
    static List<PasswordRecord> parsePasswordRecords(List<String> passwordRecordStrings, Class<? extends PasswordPolicy> passwordPolicy)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List<PasswordRecord> passwordRecords = new ArrayList<>();
        for (String passwordRecordString : passwordRecordStrings) {
            String[] parsedPasswordRecord = passwordRecordString.split("([- :])");
            int minCount = Integer.parseInt(parsedPasswordRecord[0]);
            int maxCount = Integer.parseInt(parsedPasswordRecord[1]);
            char requiredCharacter = parsedPasswordRecord[2].charAt(0);
            PasswordPolicy policy = passwordPolicy.getDeclaredConstructor(int.class, int.class, char.class).newInstance(minCount, maxCount, requiredCharacter);
            PasswordRecord record = new PasswordRecord(policy, parsedPasswordRecord[4]);
            passwordRecords.add(record);
        }
        return passwordRecords;
    }
}
