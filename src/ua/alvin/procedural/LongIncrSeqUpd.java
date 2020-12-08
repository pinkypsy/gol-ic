package ua.alvin.procedural;

import java.util.Arrays;

public class LongIncrSeqUpd {

    public static void main(String[] args) {
        longestIncreasingSubsequence(new int[]{1,2,3,3,2,4,6});
        longestIncreasingSubsequence(new int[]{6,5,3,2/*,3,4,5*/});
        longestIncreasingSubsequence(new int[]{2,4,6,1,2,3});
    }

    public static void longestIncreasingSubsequence(int[] inputArray) {
        int currentValue = 0;
        int prevValue = 0;
        int nextValue = 0;
        String tempSubsequence = "";
        String resultSubsequences = "";
        int tempCount = 0;
        int maxCount = 0;
        int startIndex = 0;
        int[] resultArray = new int[inputArray.length];
        StringBuilder a = new StringBuilder();
        /*TODO: Change this line for log*/
        System.out.println("Original array: " + Arrays.toString(inputArray));

       for (int i = 1; i < inputArray.length; i++) {
            prevValue = inputArray[i - 1];
            currentValue = inputArray[i];
//            nextValue = inputArray[i + 1];
//            if (i == 0 && (prevValue > currentValue)) {
//                tempCount++;
//                tempSubsequence += " " + currentValue;
//            }
            if (currentValue > prevValue) {
                tempCount++;
                tempSubsequence += " " + prevValue;
            } else {
                tempCount = 1;
             /*   if (prevValue > inputArray[i - 1]){
                tempSubsequence = " " +  currentValue;
                }*/
            }
            if (tempCount > maxCount) {
                maxCount = tempCount;
                resultSubsequences = tempSubsequence;
            } else if (tempCount == maxCount) {
                resultSubsequences += tempSubsequence;
            }
        }
     /*   for (int i = 0; i < inputArray.length - 1; i++) {
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
               if (currentValue > nextValue){
                    tempSubsequence = "";
                    continue;
                }
                tempSubsequence = " " +  nextValue;
            }
            if (tempCount > maxCount) {
                maxCount = tempCount;
                resultSubsequences = tempSubsequence;
            } else if (tempCount == maxCount) {
                resultSubsequences += tempSubsequence;
            }
        }*/
        System.out.println(resultSubsequences);
    }
}
