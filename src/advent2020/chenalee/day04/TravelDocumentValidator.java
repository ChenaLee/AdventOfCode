package advent2020.chenalee.day04;

class TravelDocumentValidator {
    static boolean shallowValidate(TravelDocument travelDocument) {
        // cid can be missing if all others present.
        return travelDocument.pid != null && travelDocument.iyr != null  && travelDocument.hgt != null &&
                travelDocument.hcl != null && travelDocument.eyr != null  && travelDocument.ecl != null &&
                travelDocument.byr != null;
    }

    static boolean deepValidate(TravelDocument travelDocument) {
        return shallowValidate(travelDocument) &&
                isByrValid(travelDocument.byr) && isIyrValid(travelDocument.iyr) && isEyrValid(travelDocument.eyr) &&
                isHgtValid(travelDocument.hgt) && isHclValid(travelDocument.hcl) && isEclValid(travelDocument.ecl) &&
                isPidValid(travelDocument.pid);
    }

    private static boolean isByrValid(String byr) {
        return byr.matches("^19[2-9][0-9]$|^200[0-2]$");
    }

    private static boolean isIyrValid(String iyr) {
        return iyr.matches("^201[0-9]$|^2020$");
    }

    private static boolean isEyrValid(String eyr) {
        return eyr.matches("^202[0-9]$|^2030$");
    }

    private static boolean isHgtValid(String hgt) {
        return hgt.matches("^(1[5-8][0-9]|19[0-3])cm$|^(59|6[0-9]|7[0-6])in$");
    }

    private static boolean isHclValid(String hcl) {
        return hcl.matches("^#[a-f0-9]{6}$");
    }

    private static boolean isEclValid(String ecl) {
        return ecl.matches("^(amb|blu|brn|gry|grn|hzl|oth)$");
    }

    private static boolean isPidValid(String pid) {
        return pid.matches("^\\d{9}$");
    }
}
