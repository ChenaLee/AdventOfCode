package advent2020.chenalee.day02;

class MinMaxPasswordPolicy extends PasswordPolicy {
    MinMaxPasswordPolicy(int num1, int num2, char requiredCharacter){ super(num1, num2, requiredCharacter);}

    boolean validatePassword(String password) {
        int count = countGivenCharacter(password, getRequiredCharacter());
        return count >= getNum1() && count <= getNum2();
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
