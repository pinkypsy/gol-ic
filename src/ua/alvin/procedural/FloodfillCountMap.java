package ua.alvin.procedural;

import java.util.HashMap;
import java.util.Map;

public class FloodfillCountMap {
    static Map<Integer, Integer> map = new HashMap<>();
    //    static int size = 0;
    static int size;

    public static void main(String[] args) {

        //{1=2, 2=1, 3=1, 5=1}
        int[][] originalTable = {
                {1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 1}};


        int[][] workTable = new int[originalTable.length][originalTable[0].length];

        for (int row = 0; row < originalTable.length; row++) {
            for (int column = 0; column < originalTable[row].length; column++) {
                workTable[row][column] = originalTable[row][column];
            }
            System.out.println();
        }

        /*
        //{1=3, 2=1, 8=1}
        int[][] originalTable = {
                {1, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 0, 1},
                {0, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1, 0}};*/
//        System.out.println("Result: " + countIslands(workTable));
        gridState(originalTable);
        gridState(workTable);

        countIslands(workTable);
        System.out.println(map);

    }

    public static void countIslands(int[][] grid) {
//        if (grid == null || grid.length == 0) return 0;
        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 1) {
                    result++;
                    moveThroughElements(grid, row, column);
                    map.putIfAbsent(size, 0);
                    int count = map.get(size);
                    map.put(size, ++count);
                    size = 0;
                }
            }
        }
    }

    public static void moveThroughElements(int[][] table, int row, int column) {
        if (row < 0 || column < 0 || row >= table.length || column >= table[0].length || table[row][column] == 0) {
            return;
        }
        table[row][column] = 0;
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        for (int i = 0; i < dr.length; i++) {
            moveThroughElements(table, row + dr[i], column + dc[i]);
        }
        size++;

//        System.out.println(size);
    }


    static void gridState(int[][] grid) {
        System.out.println("Grid:");
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                System.out.print(" " + grid[row][column]);
            }
            System.out.println();
        }
    }
}
