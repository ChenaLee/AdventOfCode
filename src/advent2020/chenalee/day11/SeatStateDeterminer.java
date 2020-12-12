package advent2020.chenalee.day11;

import advent2020.chenalee.util.MatrixUtil;

import java.util.List;

abstract class SeatStateDeterminer {
    List<List<String>> getNextIterationSeats(List<List<String>> seats) {
        int totalRow = seats.size();
        int totalCol = seats.get(0).size();

        List<List<String>> changedSeats = MatrixUtil.copyMatrix(seats);
        for (int row = 0; row < totalRow; row++) {
            for (int col = 0; col < totalCol; col++) {
                if (seats.get(row).get(col).equals(".")) {
                    continue;
                }
                int nearByEmptyCount =
                        (isNorthWestEmpty(row, col, seats) ? 1 : 0) +
                                (isNorthEmpty(row, col, seats) ? 1 : 0) +
                                (isNorthEastEmpty(row, col, seats) ? 1 : 0) +
                                (isWestEmpty(row, col, seats) ? 1 : 0) +
                                (isEastEmpty(row, col, seats) ? 1 : 0) +
                                (isSouthWestEmpty(row, col, seats) ? 1 : 0) +
                                (isSouthEmpty(row, col, seats) ? 1 : 0) +
                                (isSouthEastEmpty(row, col, seats) ? 1 : 0);

                if (seats.get(row).get(col).equals("L") && shouldBecomeOccupied(nearByEmptyCount)) {
                    changedSeats.get(row).set(col, "#");
                }
                if (seats.get(row).get(col).equals("#") && shouldBecomeEmpty(nearByEmptyCount)) {
                    changedSeats.get(row).set(col, "L");
                }
            }
        }
        return changedSeats;
    }

    abstract boolean shouldBecomeEmpty(int nearByEmptyCount);
    abstract boolean shouldBecomeOccupied(int nearByEmptyCount);

    abstract boolean isNorthWestEmpty(int row, int col, List<List<String>> seats);
    abstract boolean isNorthEmpty(int row, int col, List<List<String>> seats);
    abstract boolean isNorthEastEmpty(int row, int col, List<List<String>> seats);
    abstract boolean isWestEmpty(int row, int col, List<List<String>> seats);
    abstract boolean isEastEmpty(int row, int col, List<List<String>> seats);
    abstract boolean isSouthWestEmpty(int row, int col, List<List<String>> seats);
    abstract boolean isSouthEmpty(int row, int col, List<List<String>> seats);
    abstract boolean isSouthEastEmpty(int row, int col, List<List<String>> seats);
}
