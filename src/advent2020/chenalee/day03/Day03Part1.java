package advent2020.chenalee.day03;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.List;

public class Day03Part1 {
    public static void main(String[] args) throws IOException {
        List<String> forestRows = TestDataReader.readAllLines("day03.txt");
        int treesEncountered = PathObstacleCounter.countObstacleInLinearPath(forestRows, 1, 3, '#');
        System.out.println(treesEncountered);
    }
}
