package ua.alvin.procedural;

import java.util.Arrays;

public class LongestIncrSequenceInArray {

    public static void main(String[] args) {


//        int[] intArr = {1,1,2,6,7,8,8,5,5,1,2,9,9,8,7,7,7,3,3,3,3,5,7,8,8,4};
//        int maxNum = 0;
//        int maxCtr = 0;
//        int ctr = 0;
//        int pre = 0;
//
//        for (int i = 0; i < intArr.length; i++) {
//            if  (intArr[i] == pre) {
//                ctr++;
//            }
//            else {
//                if (ctr > maxCtr) {
//                    maxCtr = ctr;
//                    maxNum = pre;
//                }
//                pre = intArr[i];
//                ctr = 1;
//            }
//        }
//        System.out.println(maxNum + " - одинаковых подряд: " + maxCtr);


//        longestIncreasingSubsequence(new int[]{9,1,3,7,5,6,20});
//        longestIncreasingSubsequence(new int[]{0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15});
//        longestIncreasingSubsequence(new int[]{1,2,3,4,5,6,5,0,1,8,3,2,3});
//        longestIncreasingSubsequence(new int[]{9,4,6,8,1,8,7,9,11});
//        longestIncreasingSubsequence(new int[]{5,1,2,3,3,2,4,6});
        longestIncreasingSubsequence(new int[]{1,2,3,3,2,4,6});
        longestIncreasingSubsequence(new int[]{6,5,3,2/*,3,4,5*/});
        longestIncreasingSubsequence(new int[]{2,4,6,1,2,3});
    }

    public static void longestIncreasingSubsequence(int[] inputArray) {
        int currentValue = 0;
//        int prevValue = 0;
        int nextValue = 0;
        String tempSubsequence = "";
        String resultSubsequences = "";
        int tempCount = 0;
        int maxCount = 1;
        int startIndex = 0;
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
            } else {
                tempCount = 1;
              /* if (currentValue > nextValue){
                    tempSubsequence = "";
                    continue;
                }*/
//                tempSubsequence = "";
                tempSubsequence = " " +  nextValue;
            }
            if (tempCount > maxCount) {
                maxCount = tempCount;
                resultSubsequences = tempSubsequence;
//                tempSubsequence = "";
            } else if (tempCount == maxCount) {
                resultSubsequences += tempSubsequence;
            }
        }
        System.out.println(resultSubsequences);
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

    /*
    Вывести массив на экран. Найти самую длинную последовательность
    чисел, упорядоченную по возрастанию. Вывести ее на экран. Если таких
    последовательностей несколько (самых длинных с одинаковой длиной),
    то вывести их все.
     */
}
