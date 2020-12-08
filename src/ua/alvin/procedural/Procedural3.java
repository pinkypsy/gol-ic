package ua.alvin.procedural;

import java.util.Arrays;

public class Procedural3 {
    public static void main(String[] args) {

    /*    long l = (byte) 1234_564_890L;
        int x = (byte) 0b1000_1100_1010;
        double m = (byte) 110_987_654_6299.123_34;
        float f = (byte) l++ + 10 + ++x - (float) m;
        l = (long) f / 1000;
        System.out.println(l);

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        invertArrayReccur(array, 0);
        System.out.println(Arrays.toString(array));
        invertArrayIter(array);
        System.out.println(Arrays.toString(array));

        inverseAndReverseRecursion(1);
        System.out.println();
        System.out.println(" = " + factorial(5));*/


        long begin = System.currentTimeMillis();
        System.out.println(fibonacci(40));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    static void invertArrayReccur(int [] input, int i){
        if (input.length / 2 > i){
            int temp = input[i];
            input[i] = input[input.length - i - 1];
            input[input.length - i - 1] = temp;
            invertArrayReccur(input, i + 1);
        }
    }

    static void invertArrayIter(int [] input){
        for (int i = 0; i < input.length / 2; i++) {
            int temp = input[i];
            input[i] = input[input.length - i - 1];
            input[input.length - i - 1] = temp;
        }
    }

    static void inverseAndReverseRecursion(int arg){
        System.out.print(" " + arg);
        if (arg < 7){
            inverseAndReverseRecursion(arg * 2);
        }
        System.out.print(" " + arg);
    }
    static int factorial(int n){
        System.out.print(" " + n);
        if (n < 2){
            return n;
        }
        return factorial(n - 1) * n;
    }

    static int fibonacci(int n){
        if (n <= 2){
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

}
