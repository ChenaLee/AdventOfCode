package advent2020.chenalee.day02;

abstract class PasswordPolicy {
    private int num1;
    private int num2;
    private char requiredCharacter;

    PasswordPolicy(int num1, int num2, char requiredCharacter) {
        this.num1 = num1;
        this.num2 = num2;
        this.requiredCharacter = requiredCharacter;
    }

    abstract boolean validatePassword(String password);

    int getNum1() { return num1;}
    int getNum2() { return num2;}
    char getRequiredCharacter() { return requiredCharacter;}
}
