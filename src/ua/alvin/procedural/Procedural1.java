package ua.alvin.procedural;

import java.util.Arrays;

public class Procedural1 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        invert(array);
        System.out.println("====");
        System.out.println(Arrays.toString(array));
    }

    public static void invert(int [] input){

        for (int i = 0; i < input.length/2; i++) {
            int temp = input[input.length - i - 1];
            input[input.length - i - 1] = input[i];
            input[i] = temp;
            System.out.println(Arrays.toString(input));
        }
    }
}
