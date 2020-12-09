package ua.alvin.procedural;


import java.util.HashMap;
import java.util.Map;

public class IcebergTask {

    //    static int size = 0;
    private static int icebergSize;

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

        int[][] copiedTable = getCopiedTable(originalTable);

        showTable(originalTable);
        showTable(copiedTable);

        countIcebergs(copiedTable);



    }

    private static int[][] getCopiedTable(int[][] originalTable) {
        int[][] copy = new int[originalTable.length][originalTable[0].length];
        for (int rowNumber = 0; rowNumber < originalTable.length; rowNumber++) {
            System.arraycopy(originalTable[rowNumber], 0, copy[rowNumber], 0, originalTable[rowNumber].length);
        }
        return copy;
    }

    public static void countIcebergs(int[][] table) {
        Map<Integer, Integer> countedIcebergs = new HashMap<>();
        int icebergSize = 0;

        for (int rowNumber = 0; rowNumber < table.length; rowNumber++) {
            for (int columnNumber = 0; columnNumber < table[rowNumber].length; columnNumber++) {
//                icebergSize = 0;
                if (table[rowNumber][columnNumber] == 1) {
                    icebergSize = shiftAndComputeSize(table, rowNumber, columnNumber,icebergSize);
                    countedIcebergs.putIfAbsent(icebergSize, 0);
                    int icebergCount = countedIcebergs.get(icebergSize);
                    countedIcebergs.put(icebergSize, ++icebergCount);
                }
            }
        }
        System.out.println(countedIcebergs);
        //TODO print result
    }

    private static int shiftAndComputeSize(int[][] table, int rowNumber, int columnNumber, int icebergSize) {
//        int icebergSize = 0;
//        icebergSize++;
        if (rowNumber < 0 || columnNumber < 0 || rowNumber >= table.length || columnNumber >= table[0].length || table[rowNumber][columnNumber] == 0) {
            return 0;
        }

        table[rowNumber][columnNumber] = 0;

        shiftAndComputeSize(table, rowNumber - 1, columnNumber,icebergSize);
        shiftAndComputeSize(table, rowNumber, columnNumber + 1,icebergSize);
        shiftAndComputeSize(table, rowNumber + 1, columnNumber,icebergSize);
        shiftAndComputeSize(table, rowNumber, columnNumber - 1,icebergSize);


        return ++icebergSize;
    }

    private static void showTable(int[][] table) {
        System.out.println("Table:");
        for (int[] rows : table) {
            for (int column : rows) {
                System.out.print(" " + column);
            }
            System.out.println();
        }
    }
}
