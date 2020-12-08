package ua.alvin.procedural;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The class {@code ArraySolution} is created according to
 * Lesson06 Homework and contains methods for specified
 * tasks.
 * @author Maksim Zamanov
 */

public class ArraySolution {

    /**
     * org.apache.logging.log4j.Logger is used for logging information about
     * events.
     */
    private static final Logger LOG =
            LogManager.getLogger(ArraySolution.class);

    /**
     * The {@code int} value that represents size of iceberg
     */
    private static int icebergSize;

    /**
     * Main method that invokes methods according to homework.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        printNextIfGreaterThanPrevious(new int[]{3, 9, 8, 4, 5, 1});

        swapMinAndMaxElements(new int[]{3, -9, 1, 4, 5, 8});

        sumOfEvenNegativeNumbers(new int[]{-3, -5, -2, -4, -8, 0});

        longestIncreasingSubsequence(new int[]{9, 1, 2, 3, 8, 4, 9, 1, 2, 3,
                4});

        countIcebergs(new int[][]{
                {1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 1}
        });
    }

    /**
     * @param inputArray
     */
    public static void printNextIfGreaterThanPrevious(int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i - 1] < inputArray[i]) {
                LOG.info(inputArray[i] + " is greater than the previous one");
            }
        }
    }

    /**
     * @param inputArray
     */
    public static void swapMinAndMaxElements(int[] inputArray) {
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < inputArray.length; i++) {
            int currentValue = inputArray[i];
            if (currentValue < minElement) {
                minElement = currentValue;
                minIndex = i;
            }
            if (currentValue > maxElement) {
                maxElement = currentValue;
                maxIndex = i;
            }
        }

        inputArray[minIndex] = maxElement;
        inputArray[maxIndex] = minElement;

        LOG.info("Modified array: " + Arrays.toString(inputArray));
    }

    /**
     *
     * @param inputArray
     */
    public static void sumOfEvenNegativeNumbers(int[] inputArray) {
        int sumOfEvenNegativeNumbers = 0;

        for (int i = 0; i < inputArray.length; i++) {
            int currentValue = inputArray[i];
            if ((currentValue < 0) && (currentValue % 2 == 0)) {
                sumOfEvenNegativeNumbers = sumOfEvenNegativeNumbers + currentValue;
            }
        }
        LOG.info("Sum of even negative numbers: " + sumOfEvenNegativeNumbers);
    }

    /**
     * @param inputArray
     */
    public static void longestIncreasingSubsequence(int[] inputArray) {
        int currentValue = 0;
//        int prevValue = 0;
        int nextValue = 0;
        String tempSubsequence = "";
        String resultSubsequences = "";
        int tempCount = 0;
        int maxCount = 1;
        StringBuilder a = new StringBuilder();
        /*TODO: Change this line for log*/
        LOG.info("Original array: " + Arrays.toString(inputArray));

        for (int i = 0; i < inputArray.length - 1; i++) {
            currentValue = inputArray[i];
            nextValue = inputArray[i + 1];
            if (i == 0 && (currentValue < nextValue)) {
                tempCount++;
                tempSubsequence += " " + currentValue;
            }
            if (currentValue < nextValue) {
                tempCount++;
                tempSubsequence += " " + nextValue;
            } else {
                tempCount = 1;
                tempSubsequence = " " +  nextValue;
            }
            if (tempCount > maxCount) {
                maxCount = tempCount;
                resultSubsequences = tempSubsequence;
//                tempSubsequence = "";
            } else if (tempCount == maxCount) {
                resultSubsequences += (", " + tempSubsequence);
            }
        }
        LOG.info("Result subsequences: " + resultSubsequences);
    }

    public static void countIcebergs(int[][] originalTable) {
        int[][] copiedTable = getCopiedTable(originalTable);
        Map<Integer, Integer> countedIcebergs = new HashMap<>();

        for (int rowNumber = 0; rowNumber < copiedTable.length; rowNumber++) {
            for (int columnNumber = 0;
                 columnNumber < copiedTable[rowNumber].length;
                 columnNumber++) {
                icebergSize = 0;
                if (copiedTable[rowNumber][columnNumber] == 1) {

                    icebergSize = shiftAndComputeSize(copiedTable, rowNumber,
                            columnNumber);

                    countedIcebergs.putIfAbsent(icebergSize, 0);
                    int icebergCount = countedIcebergs.get(icebergSize);
                    countedIcebergs.put(icebergSize, ++icebergCount);
                }
            }
        }
        if (countedIcebergs.isEmpty()) {
            LOG.info("No icebergs");
        } else {
            for (Map.Entry<Integer, Integer> entry :
                    countedIcebergs.entrySet()) {
                LOG.info("size " + entry.getKey() + " - "
                        + entry.getValue()
                        + " icebergs");
            }
        }
    }

    private static int shiftAndComputeSize(int[][] table, int rowNumber,
                                           int columnNumber) {
        if (rowNumber < 0 || columnNumber < 0 || rowNumber >= table.length
                || columnNumber >= table[0].length
                || table[rowNumber][columnNumber] == 0) {
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

    private static int[][] getCopiedTable(int[][] originalTable) {
        int[][] copy = new int[originalTable.length][originalTable[0].length];
        for (int rowNumber = 0; rowNumber < originalTable.length; rowNumber++) {
            System.arraycopy(originalTable[rowNumber], 0, copy[rowNumber], 0,
                    originalTable[rowNumber].length);
        }
        return copy;
    }
}
