package advent2020.chenalee.day11;

import java.util.List;

class Util {
    static int countOccupiedSeats(List<List<String>> seats) {
        int totalRow = seats.size();
        int totalCol = seats.get(0).size();
        int occupiedSeats = 0;
        for (int row = 0; row < totalRow; row++) {
            for (int col = 0; col < totalCol; col++) {
                if (seats.get(row).get(col).equals("#")) {
                    occupiedSeats++;
                }
            }
        }
        return occupiedSeats;
    }
}
