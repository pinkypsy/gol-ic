package ua.alvin.procedural;

import org.w3c.dom.ls.LSOutput;

public class Asc {
    public static void main(String[] args) {


//        System.out.println(longestAscendingSubsequence(5123245));
//        System.out.println(longestAscendingSubsequence(123245));
        System.out.println(longestAscendingSubsequence(245123));
//        System.out.println(longestAscendingSubsequence(752338338));

    }

    static int longestAscendingSubsequence(int originalNumber) {
        int currentPosition = originalNumber;
        int currentDigit;
        int nextDigit;
        int revolvedTempSequence = 0;
        int resultSubsequence = 0;
        while (currentPosition != 0) {
            currentDigit = currentPosition % 10;
            currentPosition /= 10;
            nextDigit = currentPosition % 10;

            if (currentDigit >= (revolvedTempSequence%10)){
                revolvedTempSequence = (revolvedTempSequence * 10) + currentDigit;

            } else {
                if (currentDigit <= revolvedTempSequence % 10){
                    revolvedTempSequence = (revolvedTempSequence * 10) + currentDigit;
                }


            }
            if (revolvedTempSequence > resultSubsequence) {
                resultSubsequence = revolvedTempSequence;

            }
            resultSubsequence = revolvedTempSequence;
//            revolvedTempSequence = 0;
        }

        return resultSubsequence;
    }

//    private static int getLongestRun(int[] array) {
//        int count = 1;
//        int max = 1;
//
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] == array[i - 1]) {
//                count++;
//            }
//            else {
//                count = 1;
//            }
//            if (count > max) {
//                max = count;
//            }
//        }
//
//        // you forgot to return the length of the longest sequence to the caller
//        return max;
//    }
}
