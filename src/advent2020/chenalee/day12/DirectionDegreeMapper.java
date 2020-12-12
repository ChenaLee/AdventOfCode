package advent2020.chenalee.day12;

public class DirectionDegreeMapper {
    public static int getDegree(String direction) {
        switch (direction) {
            case "N": return 0;
            case "S": return 180;
            case "W": return 270;
            case "E": return 90;
            default: throw new RuntimeException();
        }
    }

    public static String getDirection(int degree) {
        int positiveDegreeIn360Range = ((degree % 360) + 360) % 360;
        switch (positiveDegreeIn360Range) {
            case 0: return "N";
            case 180: return "S";
            case 270: return "W";
            case 90: return "E";
            default: throw new RuntimeException();
        }
    }
}
