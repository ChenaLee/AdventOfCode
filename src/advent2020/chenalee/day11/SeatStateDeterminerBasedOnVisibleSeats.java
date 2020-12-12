package advent2020.chenalee.day11;

import java.util.List;

class SeatStateDeterminerBasedOnVisibleSeats extends SeatStateDeterminer {
    boolean shouldBecomeEmpty(int nearByEmptyCount) {
        return nearByEmptyCount < 4;
    }
    boolean shouldBecomeOccupied(int nearByEmptyCount) {
        return nearByEmptyCount == 8;
    }

    boolean isNorthWestEmpty(int row, int col, List<List<String>> seats) {
        return row == 0 || col == 0 ||
                seats.get(row - 1).get(col - 1).matches("L") ||
                (seats.get(row - 1).get(col - 1).matches("\\.") &&
                        isNorthWestEmpty(row - 1, col - 1, seats));
    }
    boolean isNorthEmpty(int row, int col, List<List<String>> seats) {
        return row == 0 ||
                seats.get(row - 1).get(col).matches("L") ||
                (seats.get(row - 1).get(col).matches("\\.") &&
                        isNorthEmpty(row - 1, col, seats));
    }
    boolean isNorthEastEmpty(int row, int col, List<List<String>> seats) {
        return row == 0 || col == seats.get(0).size() -1 ||
                seats.get(row - 1).get(col + 1).matches("L") ||
                (seats.get(row - 1).get(col + 1).matches("\\.") &&
                        isNorthEastEmpty(row - 1, col + 1, seats));
    }
    boolean isWestEmpty(int row, int col, List<List<String>> seats) {
        return col == 0 ||
                seats.get(row).get(col - 1).matches("L") ||
                (seats.get(row).get(col - 1).matches("\\.") &&
                        isWestEmpty(row, col - 1, seats));
    }
    boolean isEastEmpty(int row, int col, List<List<String>> seats) {
        return col == seats.get(0).size() - 1 ||
                seats.get(row).get(col + 1).matches("L") ||
                (seats.get(row).get(col + 1).matches("\\.") &&
                        isEastEmpty(row, col + 1, seats));
    }
    boolean isSouthWestEmpty(int row, int col, List<List<String>> seats) {
        return row == seats.size() - 1 || col == 0 ||
                seats.get(row + 1).get(col - 1).matches("L") ||
                (seats.get(row + 1).get(col - 1).matches("\\.") &&
                        isSouthWestEmpty(row + 1, col - 1, seats));
    }
    boolean isSouthEmpty(int row, int col, List<List<String>> seats) {
        return row == seats.size() - 1 ||
                seats.get(row + 1).get(col).matches("L") ||
                (seats.get(row + 1).get(col).matches("\\.") &&
                        isSouthEmpty(row + 1, col, seats));
    }
    boolean isSouthEastEmpty(int row, int col, List<List<String>> seats) {
        return row == seats.size() - 1 || col == seats.get(0).size() -1 ||
                seats.get(row + 1).get(col + 1).matches("L") ||
                (seats.get(row + 1).get(col + 1).matches("\\.") &&
                        isSouthEastEmpty(row + 1,col + 1, seats));
    }
}
