package advent2020.chenalee.day03;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.List;

public class Day03Part2 {
    public static void main(String[] args) throws IOException {
        List<String> forestRows = TestDataReader.readAllLines("day03.txt");

        long treesEncountered1 = PathObstacleCounter.countObstacleInLinearPath(forestRows, 1, 1, '#');
        long treesEncountered2 = PathObstacleCounter.countObstacleInLinearPath(forestRows, 1, 3, '#');
        long treesEncountered3 = PathObstacleCounter.countObstacleInLinearPath(forestRows, 1, 5, '#');
        long treesEncountered4 = PathObstacleCounter.countObstacleInLinearPath(forestRows, 1, 7, '#');
        long treesEncountered5 = PathObstacleCounter.countObstacleInLinearPath(forestRows, 2, 1, '#');

        System.out.println(treesEncountered1*treesEncountered2*treesEncountered3*treesEncountered4*treesEncountered5);
    }
}
