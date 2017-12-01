package ine5611;

public class Forest {

    Bowl[] bowls;
    protected static int[][] ways = {
        {2, 15}, {1, 3, 4, 5}, {2, 9}, {2, 9, 10}, {2, 6}, {7, 8}, {6}, {6},
        {3, 4, 15, 18}, {4, 12}, {12, 14, 17}, {10, 11, 13}, {12}, {11, 16},
        {1, 9}, {14, 17, 18, 20}, {11, 16}, {9, 16, 19}, {18, 20}, {16, 19}
    };

    public Forest() {
        bowls = new Bowl[20];
        for (int i = 0; i < 20; i++) {
            bowls[i] = new Bowl(ways[i], i + 1);
        }
    }

    public Bowl getPote(int bowlNumber) {
        return bowls[bowlNumber - 1];
    }
}
