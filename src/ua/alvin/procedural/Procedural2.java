package ua.alvin.procedural;

import java.util.Arrays;

public class Procedural2 {
    public static void main(String[] args) {
        printPlusIfFirstPlusSecondBiggerThanThree();
        System.out.println(" = = = = =");
        printPlusIfFirstBiggerThanSecond();
        System.out.println(" = = = = =");
        arrayNestedTraversal();
        System.out.println(" = = = = =");
        arrayNestedDependentTraversal();
        System.out.println(" = = = = =");

    }


    static void printPlusIfFirstPlusSecondBiggerThanThree() {

        for (int first = 0; first < 5; first++) {
            for (int second = 0; second < 5; second++) {
                System.out.print((first + second > 3) ? " + " : " - ");
            }
            System.out.println();
        }
    }

    static void printPlusIfFirstBiggerThanSecond() {
        for (int first = 0; first < 5; first++) {
            for (int second = 0; second < 5; second++) {
                System.out.print((first > second) ? " + " : " - ");
            }
            System.out.println();
        }
    }

    static void arrayNestedTraversal() {
        int[] array = {10, 20, 30, 40, 50};

        for (int i = array.length - 1; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
    }

    static void arrayNestedDependentTraversal() {
        int[] array = {10, 20, 30, 40, 50};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
    }
}
