package ua.alvin.procedural;

import java.util.Arrays;
import java.util.Random;

public class InsertionSortWithBinarySearch {

    public static void main(String[] args) {
        InsertionSortWithBinarySearch sort = new InsertionSortWithBinarySearch();
//        int[] array = sort.createRandomArray(100000);
        int [] array = new int[]{55, -15, -22, 7, 35, 20, 1};
        sort.evaluateAlgorithm(array);
        System.out.println(Arrays.toString(array));
    }

    public void insertionSort(int [] input){
        for (int barrier = 1; barrier < input.length; barrier++) {
            int elemNew = input[barrier];
            int curPosition = barrier - 1;

            while (curPosition >= 0 && input[curPosition] > elemNew){
                input[curPosition + 1] = input[curPosition];
                curPosition--;
            }
            input[curPosition + 1] = elemNew;
        }
    }

/*    public void insertionSort(int [] input){
        for (int barrier = 1; barrier < input.length; barrier++) {
            int elemNew = input[barrier];
            int curPosition = barrier - 1;

            int indexNew = (Arrays.binarySearch(input, 0, barrier, elemNew));

            if (indexNew < 0) {
                indexNew = -indexNew - 1;
            }

//            while (curPosition >= 0 && input[curPosition] > elemNew){
//                input[curPosition + 1] = input[curPosition];
//                curPosition--;
//            }
            input[curPosition + 1] = input[indexNew];
            input[indexNew] = elemNew;
        }
    }*/

    private void evaluateAlgorithm(int [] arr){
        long begin = System.currentTimeMillis();
        insertionSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Sort time: " + (end - begin) + " ms.");
    }

    private int[] createRandomArray(int size) {
        int[] array = new int[size];

        Random random = new Random();
        for (int i = 0; i < size - 1; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

}
