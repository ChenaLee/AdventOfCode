package advent2020.chenalee.day03;

import java.util.List;

class PathObstacleCounter {
    static int countObstacleInLinearPath(List<String> matrix, int rowIncrement, int columnIncrement, char obstacle) {
        int totalColumns = matrix.get(0).length();

        int columnIndex = 0;
        int rowIndex = 0;
        int obstaclesEncountered = 0;
        while (rowIndex < matrix.size()) {
            if (matrix.get(rowIndex).charAt(columnIndex) == obstacle) {
                obstaclesEncountered++;
            }
            rowIndex = rowIndex + rowIncrement;
            columnIndex = (columnIndex + columnIncrement) % totalColumns;
        }

        return obstaclesEncountered;
    }
}
