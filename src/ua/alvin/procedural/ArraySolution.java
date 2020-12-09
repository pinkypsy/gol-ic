//package com.solution;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * The class {@code ArraySolution} is created according to
// * Lesson06 Homework and contains various methods for manipulating arrays.
// *
// * @author Maksim Zamanov
// */
//
//public class ArraySolution {
//
//    /**
//     * {@code int} org.apache.logging.log4j.Logger is used for logging
//     * information about events.
//     */
//    private static final Logger LOG =
//            LogManager.getLogger(ArraySolution.class);
//
//    /**
//     * The shared {@code int} variable that stores the size of the iceberg
//     * before put it to the map
//     */
//    private static int icebergSize;
//
//    /**
//     * Main method that invokes methods according to homework.
//     * @param args - the command line arguments.
//     */
//    public static void main(String[] args) {
//        printNextIfGreaterThanPrevious(new int[]{3, 9, 8, 4, 5, 1});
//
//        swapMinAndMaxElements(new int[]{3, -9, 1, 4, 5, 8});
//
//        sumOfEvenNegativeNumbers(new int[]{-3, -5, -2, -4, -8, 0});
//
//        longestIncreasingSubsequence(new int[]{9, 1, 2, 3, 2, 9, 2, 4, 6});
//
//        countIcebergs(new int[][]{
//                {1, 0, 0, 0, 0, 0},
//                {1, 1, 0, 0, 1, 0},
//                {0, 0, 0, 0, 0, 1},
//                {1, 1, 0, 0, 0, 0},
//                {1, 1, 1, 0, 1, 1}
//        });
//    }
//
//    /**
//     * Method for task #1: traverse through the {@code int[] inputArray} and
//     * log next element if it is greater than its previous element.
//     * @param inputArray - the input array to be processed
//     */
//    public static void printNextIfGreaterThanPrevious(int[] inputArray) {
//        for (int i = 1; i < inputArray.length; i++) {
//            if (inputArray[i - 1] < inputArray[i]) {
//                LOG.info(inputArray[i] + " is greater than the previous one");
//            }
//        }
//    }
//
//    /**
//     * Method for task #2: traverse through the {@code int[] inputArray}, swap
//     * its minimum and maximum elements and log the result.
//     * @param inputArray - the input array to be processed
//     */
//    public static void swapMinAndMaxElements(int[] inputArray) {
//        int minElement = Integer.MAX_VALUE;
//        int maxElement = Integer.MIN_VALUE;
//        int minIndex = 0;
//        int maxIndex = 0;
//
//        for (int i = 0; i < inputArray.length; i++) {
//            int currentValue = inputArray[i];
//            if (currentValue < minElement) {
//                minElement = currentValue;
//                minIndex = i;
//            }
//            if (currentValue > maxElement) {
//                maxElement = currentValue;
//                maxIndex = i;
//            }
//        }
//
//        inputArray[minIndex] = maxElement;
//        inputArray[maxIndex] = minElement;
//
//        LOG.info("Modified array: " + Arrays.toString(inputArray));
//    }
//
//    /**
//     * Method for task #3: counts sum of even negative elements of the {@code
//     * int[] inputArray} and log the result.
//     * @param inputArray - the input array to be processed
//     */
//    public static void sumOfEvenNegativeNumbers(int[] inputArray) {
//        int sumOfEvenNegativeNums = 0;
//
//        for (int i = 0; i < inputArray.length; i++) {
//            int currentValue = inputArray[i];
//            if ((currentValue < 0) && (currentValue % 2 == 0)) {
//                sumOfEvenNegativeNums = sumOfEvenNegativeNums + currentValue;
//            }
//        }
//        LOG.info("Sum of even negative numbers: " + sumOfEvenNegativeNums);
//    }
//
//    /**
//     * Method for task #4: traverse through the {@code int[] inputArray} and
//     * looks for the longest increasing subsequences and then log them all.
//     * @param inputArray - the input array to be processed
//     */
//    public static void longestIncreasingSubsequence(int[] inputArray) {
//        int currentValue;
//        int nextValue;
//        int tempCount = 0;
//        int maxCount = 0;
//        boolean isIncreasing = false;
//        String tempSubsequence = "";
//        String resultSubsequences = "";
//
//        LOG.info("Original array: " + Arrays.toString(inputArray));
//
//        for (int i = 0; i < inputArray.length - 1; i++) {
//            currentValue = inputArray[i];
//            nextValue = inputArray[i + 1];
//            if (i == 0 && (currentValue < nextValue)) {
//                tempCount++;
//                tempSubsequence += " " + currentValue;
//            }
//            if (currentValue < nextValue) {
//                tempCount++;
//                tempSubsequence += " " + nextValue;
//                isIncreasing = true;
//            } else {
//                tempCount = 1;
//                tempSubsequence = " " +  nextValue;
//            }
//            if (tempCount > maxCount && isIncreasing) {
//                maxCount = tempCount;
//                resultSubsequences = tempSubsequence;
//            } else if (tempCount == maxCount) {
//                resultSubsequences += (", " + tempSubsequence);
//            }
//        }
//        LOG.info("Result subsequences: " + resultSubsequences);
//    }
//
//    /**
//     * Method for task #4: traverse through {@code int[] originalTable} and
//     * counts size of the icebergs with utility method {@code
//     * shiftAndComputeSize}
//     *
//     * @see ArraySolution#traverseAndComputeSize(int[][], int, int)
//     * @param originalTable - the input table to be processed
//     */
//    public static void countIcebergs(int[][] originalTable) {
//        int[][] copiedTable = getCopiedTable(originalTable);
//        Map<Integer, Integer> countedIcebergs = new HashMap<>();
//
//        for (int rowNumber = 0; rowNumber < copiedTable.length; rowNumber++) {
//            for (int columnNumber = 0;
//                 columnNumber < copiedTable[rowNumber].length;
//                 columnNumber++) {
//                icebergSize = 0;
//                if (copiedTable[rowNumber][columnNumber] == 1) {
//
//                    icebergSize = traverseAndComputeSize(copiedTable, rowNumber,
//                            columnNumber);
//
//                    countedIcebergs.putIfAbsent(icebergSize, 0);
//                    int icebergCount = countedIcebergs.get(icebergSize);
//                    countedIcebergs.put(icebergSize, ++icebergCount);
//                }
//            }
//        }
//        if (countedIcebergs.isEmpty()) {
//            LOG.info("No icebergs");
//        } else {
//            for (Map.Entry<Integer, Integer> entry :
//                    countedIcebergs.entrySet()) {
//                LOG.info("size " + entry.getKey() + " - "
//                        + entry.getValue()
//                        + " icebergs");
//            }
//        }
//    }
//
//    private static int traverseAndComputeSize(int[][] table, int rowNumber,
//                                              int columnNumber) {
//        if (rowNumber < 0 || columnNumber < 0 || rowNumber >= table.length
//                || columnNumber >= table[0].length
//                || table[rowNumber][columnNumber] == 0) {
//            return 0;
//        }
//
//        table[rowNumber][columnNumber] = 0;
//
//        traverseAndComputeSize(table, rowNumber - 1, columnNumber);
//        traverseAndComputeSize(table, rowNumber, columnNumber + 1);
//        traverseAndComputeSize(table, rowNumber + 1, columnNumber);
//        traverseAndComputeSize(table, rowNumber, columnNumber - 1);
//
//        icebergSize++;
//        return icebergSize;
//    }
//
//    private static int[][] getCopiedTable(int[][] originalTable) {
//        int[][] copy = new int[originalTable.length][originalTable[0].length];
//        for (int rowNumber = 0; rowNumber < originalTable.length; rowNumber++) {
//            System.arraycopy(originalTable[rowNumber], 0, copy[rowNumber], 0,
//                    originalTable[rowNumber].length);
//        }
//        return copy;
//    }
//}
