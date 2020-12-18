package advent2020.chenalee.day17;

import advent2020.chenalee.util.TestDataReader;

import java.io.IOException;
import java.util.List;

public class Day17Part1 {

    public static void main(String[] args) throws IOException {
        List<String> lines = TestDataReader.readAllLines("day17_simple.txt");

        Grid3d grid3d = new Grid3d();
        for (int y = 0; y < lines.size(); y++) {
            String[] lineSplit = lines.get(y).split("");
            for (int z = 0; z < lineSplit.length; z++) {
                grid3d.put(0, y, z, lineSplit[z]);
            }
        }

        for (int round = 0; round < 6; round++) {
            Grid3d newGrid3d = new Grid3d();
            newGrid3d.injectData(grid3d.getData());
            for (int x : grid3d.getData().keySet()) {
                for (int y : grid3d.getData().get(x).keySet()) {
                    for (int z : grid3d.getData().get(x).get(y).keySet()) {
                        int activeNeighbors = newGrid3d.countActiveNeighbors(x, y, z);
                        if (newGrid3d.isActive(x, y, z) && activeNeighbors != 2 && activeNeighbors != 3) {
                            newGrid3d.switchState(x, y, z);
                        }
                        if (!newGrid3d.isActive(x, y, z) && activeNeighbors == 3) {
                            newGrid3d.switchState(x, y, z);
                        }
                    }
                }
            }
            grid3d = newGrid3d;
        }

        System.out.println(grid3d.getTotalActive());
    }
}
