package advent2020.chenalee.day04;

class TravelDocumentCidWaivedValidator extends TravelDocumentValidator{
    boolean validate(TravelDocument travelDocument) {
        // cid can be missing if all others present.
        return travelDocument.pid != null && travelDocument.iyr != null  && travelDocument.hgt != null &&
                travelDocument.hcl != null && travelDocument.eyr != null  && travelDocument.ecl != null &&
                travelDocument.byr != null;
    }
}
