package advent2020.chenalee.day11;

import java.util.List;

class SeatStateDeterminerBasedOnAdjacentSeats extends SeatStateDeterminer {

    boolean shouldBecomeEmpty(int nearByEmptyCount) {
        return nearByEmptyCount < 5;
    }
    boolean shouldBecomeOccupied(int nearByEmptyCount) {
        return nearByEmptyCount == 8;
    }

    boolean isNorthWestEmpty(int row, int col, List<List<String>> seats) {
        return row == 0 || col == 0 || seats.get(row - 1).get(col - 1).matches("L|\\.");
    }
    boolean isNorthEmpty(int row, int col, List<List<String>> seats) {
        return row == 0 || seats.get(row - 1).get(col).matches("L|\\.");
    }
    boolean isNorthEastEmpty(int row, int col, List<List<String>> seats) {
        return row == 0 || col == seats.get(0).size() -1 || seats.get(row - 1).get(col + 1).matches("L|\\.");
    }
    boolean isWestEmpty(int row, int col, List<List<String>> seats) {
        return col == 0 || seats.get(row).get(col - 1).matches("L|\\.");
    }
    boolean isEastEmpty(int row, int col, List<List<String>> seats) {
        return col == seats.get(0).size() - 1 || seats.get(row).get(col + 1).matches("L|\\.");
    }
    boolean isSouthWestEmpty(int row, int col, List<List<String>> seats) {
        return row == seats.size() - 1 || col == 0 || seats.get(row + 1).get(col - 1).matches("L|\\.");
    }
    boolean isSouthEmpty(int row, int col, List<List<String>> seats) {
        return row == seats.size() - 1 || seats.get(row + 1).get(col).matches("L|\\.");
    }
    boolean isSouthEastEmpty(int row, int col, List<List<String>> seats) {
        return row == seats.size() - 1 || col == seats.get(0).size() -1 || seats.get(row + 1).get(col + 1).matches("L|\\.");
    }
}
