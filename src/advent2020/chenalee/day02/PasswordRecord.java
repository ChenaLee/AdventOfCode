package advent2020.chenalee.day02;

class PasswordRecord {
    private PasswordPolicy passwordPolicy;
    private String password;

    PasswordRecord(PasswordPolicy passwordPolicy, String password) {
        this.passwordPolicy = passwordPolicy;
        this.password = password;
    }

    PasswordPolicy getPasswordPolicy() {return passwordPolicy;}
    String getPassword() { return password;}
}
