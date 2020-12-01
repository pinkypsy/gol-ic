package ua.alvin.procedural;

import java.util.Arrays;

public class CombinatorialPermutator {
    public static void main(String[] args) {

        permute(new int [] {1, 2, 3}, 3);
    }
/*FIXME DOES NOT WORK*/
    static void permute(int [] input, int size){
        if (size < 2){
            System.out.println(Arrays.toString(input));
        } else {
            for (int k = 0; k < size; k++) {
                permute(input, size - 1);
                swap(input, k, size - 1);
            }
        }
    }

    static void swap(int [] array, int index0, int index1){
        int tmp = array[index0];
        array[index0] = array[index1];
        array[index1] = tmp;
    }
}
