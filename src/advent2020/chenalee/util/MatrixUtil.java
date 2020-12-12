package advent2020.chenalee.util;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtil {
    public static List<List<String>> copyMatrix(List<List<String>> src) {
        List<List<String>> dest = new ArrayList<>();
        for( List<String> sublist : src) {
            dest.add(new ArrayList<>(sublist));
        }
        return dest;
    }
}
