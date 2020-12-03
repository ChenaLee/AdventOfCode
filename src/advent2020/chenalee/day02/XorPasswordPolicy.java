package advent2020.chenalee.day02;

class XorPasswordPolicy extends PasswordPolicy {
    XorPasswordPolicy(int num1, int num2, char requiredCharacter){ super(num1, num2, requiredCharacter);}

    boolean validatePassword(String password) {
        return (password.charAt(getNum1() - 1) == getRequiredCharacter()) ^
                (password.charAt(getNum2() - 1) == getRequiredCharacter());
    }
}
