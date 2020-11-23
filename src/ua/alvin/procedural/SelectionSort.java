package ua.alvin.procedural;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
//        int[] array = createRandomArray(10);
        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
        evaluateAlgorithm(array);
        System.out.println(Arrays.toString(array));
    }

    static void selectionSort(int[] input) {

        for (int lastUnsortedIndex = input.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int indexOfLargest = 0;
            for (int currentIndex = 1; currentIndex <= lastUnsortedIndex; currentIndex++) {
                if (input[currentIndex] > input[indexOfLargest]) {
                    indexOfLargest = currentIndex;
                }
            }
            swap(input,indexOfLargest,lastUnsortedIndex);
        }

    }

    private static void swap(int[] arr, int toBiggerPosition, int toSmallerPosition) {

        if (toBiggerPosition == toSmallerPosition) return;

        int temp = arr[toBiggerPosition];
        arr[toBiggerPosition] = arr[toSmallerPosition];
        arr[toSmallerPosition] = temp;
    }

    private static void evaluateAlgorithm(int [] arr){
        long begin = System.currentTimeMillis();
        selectionSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Sort time: " + (end - begin) + " ms.");
    }

    private static int[] createRandomArray(int size) {
        int[] array = new int[size];

        Random random = new Random();
        for (int i = 0; i < size - 1; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }
}
