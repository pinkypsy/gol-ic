package ua.alvin.procedural;

import java.util.Arrays;

public class LongestIncrSequenceInArray {

    public static void main(String[] args) {

        longestIncreasingSubsequence(new int[]{9,1,3,7,5,6,20});
        longestIncreasingSubsequence(new int[]{0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15});
        longestIncreasingSubsequence(new int[]{1,2,3,4,5,6,5,0,1,8,3,2,3});
        longestIncreasingSubsequence(new int[]{9,4,6,8,1,8,7,9,11});
        longestIncreasingSubsequence(new int[]{5,1,2,3,3,2,4,6});
        longestIncreasingSubsequence(new int[]{1,2,3,3,2,4,6});
        longestIncreasingSubsequence(new int[]{6,5,3,2/*,3,4,5*/});
        longestIncreasingSubsequence(new int[]{2,4,6,1,2,3});
        longestIncreasingSubsequence(new int[]{3,2,1,2,4,6});
        System.out.println();

//        findIterative(new int[]{2,4,6,1,2,3});
    }

    public static void longestIncreasingSubsequence(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return;
        }
        int currentValue = 0;
//        int prevValue = 0;
        int nextValue = 0;
        String tempSubsequence = "";
        String resultSubsequences = "";
        int tempCount = 0;
        int maxCount = 0;
        int startIndex = 0;
        boolean isIncreasing = false;
        int[] resultArray = new int[inputArray.length];
        StringBuilder a = new StringBuilder();
        /*TODO: Change this line for log*/
        System.out.println("Original array: " + Arrays.toString(inputArray));

        for (int i = 0; i < inputArray.length - 1; i++) {
            currentValue = inputArray[i];
            nextValue = inputArray[i + 1];
            if (i == 0 && (currentValue < nextValue)) {
                tempCount++;
                tempSubsequence += " " + currentValue;
            }
            if (currentValue < nextValue) {
                tempCount++;
                tempSubsequence += " " + nextValue;
                isIncreasing = true;
            } else {
                tempCount = 1;
              /* if (currentValue > nextValue){
                    tempSubsequence = "";
                    continue;
                }*/
//                tempSubsequence = "";
                tempSubsequence = " " +  nextValue;
            }
            if (tempCount > maxCount && isIncreasing) {
                maxCount = tempCount;
                resultSubsequences = tempSubsequence;
//                tempSubsequence = "";
            } else if (tempCount == maxCount) {
                resultSubsequences += "\n" + tempSubsequence;
            }
        }
        System.out.println(resultSubsequences);
    }

   /* public static int findIterative(int[] numbers) {
        //validateInput(numbers);
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        boolean consecutiveSequenceFound = false;
        int result = 0;
        int start = 0, end = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] < numbers[i]) {
                end = i;
            } else {
                start = i;
            }
            if (end - start > result) {
                consecutiveSequenceFound = true;
                result = end - start;
            }
        }
        if (consecutiveSequenceFound) {
            return result + 1;
        } else {
            return result;
        }
    }*/

    public static void findIterative(int[] numbers) {

        String tempSubsequence = "";
        String resultSubsequences = "";
        boolean consecutiveSequenceFound = false;
        int result = 0;
        int start = 0, end = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] < numbers[i]) {
                end = i;
            } else {
                start = i;
            }
            if (end - start > result) {
                consecutiveSequenceFound = true;
                result = end - start;
            }
        }
     /*   if (consecutiveSequenceFound) {
            return result + 1;
        } else {
            return result;
        }*/
        System.out.println(result);
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int[] max = new int[nums.length];
        Arrays.fill(max, 1);

        int result = 1;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    max[i]= Math.max(max[i], max[j]+1);//8

                }
            }
            result = Math.max(max[i], result);
        }

        return result;
    }

}
