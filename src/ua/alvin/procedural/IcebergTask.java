package ua.alvin.procedural;


import java.util.HashMap;
import java.util.Map;

public class IcebergTask {
    static Map<Integer, Integer> map = new HashMap<>();
    //    static int size = 0;
    static int icebergSize;

    public static void main(String[] args) {

        //{1=2, 2=1, 3=1, 5=1}
        int[][] originalTable = {
                {1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 1}};

        /*int[][] originalTable = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};*/
        //{1=2, 4=1, 9=1}
/*
        int[][] originalTable = {
                {1, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 1, 0, 0, 1, 0}};
*/

        int[][] workTable = new int[originalTable.length][originalTable[0].length];

        for (int row = 0; row < originalTable.length; row++) {
            for (int column = 0; column < originalTable[row].length; column++) {
                workTable[row][column] = originalTable[row][column];
            }
            System.out.println();
        }

//        System.out.println("Result: " + countIslands(workTable));
        gridState(originalTable);
        gridState(workTable);

        countIcebergs(workTable);
        System.out.println(map);

    }

    public static void countIcebergs(int[][] table) {
        for (int rowNumber = 0; rowNumber < table.length; rowNumber++) {
            for (int columnNumber = 0; columnNumber < table[rowNumber].length; columnNumber++) {
                icebergSize = 0;
                if (table[rowNumber][columnNumber] == 1) {
                    icebergSize = shiftAndComputeSize(table, rowNumber, columnNumber);
                    map.putIfAbsent(icebergSize, 0);
                    int icebergCount = map.get(icebergSize);
                    map.put(icebergSize, ++icebergCount);
                }
            }
        }
    }

    public static int shiftAndComputeSize(int[][] table, int rowNumber, int columnNumber) {
        if (rowNumber < 0 || columnNumber < 0 || rowNumber >= table.length || columnNumber >= table[0].length || table[rowNumber][columnNumber] == 0) {
            return 0;
        }

        table[rowNumber][columnNumber] = 0;

        shiftAndComputeSize(table, rowNumber - 1, columnNumber);
        shiftAndComputeSize(table, rowNumber, columnNumber + 1);
        shiftAndComputeSize(table, rowNumber + 1, columnNumber);
        shiftAndComputeSize(table, rowNumber, columnNumber - 1);

        icebergSize++;
        return icebergSize;
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
