package advent2020.chenalee.day17;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Grid3d {
    private Map<Integer, Map<Integer, Map<Integer, String>>> data = new HashMap<>();

    public void injectData(Map<Integer, Map<Integer, Map<Integer, String>>> inputData) {
        for (int x : inputData.keySet()) {
            for (int y : inputData.get(x).keySet()) {
                for (int z : inputData.get(x).get(y).keySet()) {
                    put(x, y, z, inputData.get(x).get(y).get(z));
                }
            }
        }
    }

    public void put(int x, int y, int z, String input) {
        data.computeIfAbsent(x, k -> new HashMap<>());
        data.get(x).computeIfAbsent(y, k -> new HashMap<>());
        data.get(x).get(y).put(z, input);
    }

    public boolean isActive(int x, int y, int z) {
        data.computeIfAbsent(x, k -> new HashMap<>());
        data.get(x).computeIfAbsent(y, k -> new HashMap<>());
        data.get(x).get(y).putIfAbsent(z, ".");
        return data.get(x).get(y).get(z).equals(".");
    }

    public void switchState(int x, int y, int z) {
        if (data.get(x).get(y).get(z).equals(".")) {
            data.get(x).get(y).put(z, "#");
        } else {
            data.get(x).get(y).put(z, ".");
        }
    }

    public int getTotalActive() {
        int totalActive = 0;
        for (int x : data.keySet()) {
            for (int y : data.get(x).keySet()) {
                for (int z : data.get(x).get(y).keySet()) {
                    totalActive += (isActive(x, y, z) ? 1 : 0);
                }
            }
        }
        return totalActive;
    }

    public int countActiveNeighbors(int x, int y, int z) {
        return (isActive(x, y, z - 1) ? 1 : 0)
                + (isActive(x, y, z + 1) ? 1 : 0)
                + (isActive(x, y + 1, z) ? 1 : 0)
                + (isActive(x, y + 1, z - 1) ? 1 : 0)
                + (isActive(x, y + 1, z + 1) ? 1 : 0)
                + (isActive(x, y - 1, z) ? 1 : 0)
                + (isActive(x, y - 1, z - 1) ? 1 : 0)
                + (isActive(x, y - 1, z + 1) ? 1 : 0)
                + (isActive(x - 1, y, z) ? 1 : 0)
                + (isActive(x - 1, y, z - 1) ? 1 : 0)
                + (isActive(x - 1, y, z + 1) ? 1 : 0)
                + (isActive(x - 1, y + 1, z) ? 1 : 0)
                + (isActive(x - 1, y + 1, z - 1) ? 1 : 0)
                + (isActive(x - 1, y + 1, z + 1) ? 1 : 0)
                + (isActive(x - 1, y - 1, z) ? 1 : 0)
                + (isActive(x - 1, y - 1, z - 1) ? 1 : 0)
                + (isActive(x - 1, y - 1, z + 1) ? 1 : 0)
                + (isActive(x + 1, y, z) ? 1 : 0)
                + (isActive(x + 1, y, z - 1) ? 1 : 0)
                + (isActive(x + 1, y, z + 1) ? 1 : 0)
                + (isActive(x + 1, y + 1, z) ? 1 : 0)
                + (isActive(x + 1, y + 1, z - 1) ? 1 : 0)
                + (isActive(x + 1, y + 1, z + 1) ? 1 : 0)
                + (isActive(x + 1, y - 1, z) ? 1 : 0)
                + (isActive(x + 1, y - 1, z - 1) ? 1 : 0)
                + (isActive(x + 1, y - 1, z + 1) ? 1 : 0);
    }
}
