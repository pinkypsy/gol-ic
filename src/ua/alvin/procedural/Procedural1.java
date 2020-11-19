package ua.alvin.procedural;

import java.util.Arrays;

public class Procedural1 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        invertIter(array);
//        invertRec(array,0);
        System.out.println("====");
        System.out.println(Arrays.toString(array));
    }

    public static void invertIter(int [] input){

//        for (int i = 0; i < input.length/2; i++) {
//            int temp = input[input.length - i - 1];
//            input[input.length - i - 1] = input[i];
//            input[i] = temp;
//            System.out.println(Arrays.toString(input));
//        }

        for (int i = input.length/2 - 1; i >= 0; i--) {
            int temp = input[input.length - i - 1];
            input[input.length - i - 1] = input[i];
            input[i] = temp;
            System.out.println(Arrays.toString(input));
        }
    }

    public static void invertRec(int [] input, int i){
        if (i < input.length / 2){
            int temp = input[input.length - i - 1];
            input[input.length - i - 1] = input[i];
            input[i] = temp;
            invertRec(input,++i);
        }

    }
}
