package ua.alvin.procedural;

import java.util.Arrays;

public class LongestSubArrays {
    public static void main(String[] args) {
        longestIncreasingSubsequence(new int[]{9, 1, 3, 7, 5, 6, 20});
        longestIncreasingSubsequence(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15});
        longestIncreasingSubsequence(new int[]{1, 2, 3, 4, 5, 6, 5, 0, 1, 8, 3, 2, 3});
        longestIncreasingSubsequence(new int[]{9, 4, 6, 8, 1, 8, 7, 9, 11});
        longestIncreasingSubsequence(new int[]{5, 1, 2, 3, 3, 2, 4, 6});
        longestIncreasingSubsequence(new int[]{1, 2, 3, 3, 2, 4, 6});
        longestIncreasingSubsequence(new int[]{6, 5, 3, 2,3,4,5});
        longestIncreasingSubsequence(new int[]{2, 4, 6, 1, 2, 3});
        longestIncreasingSubsequence(new int[]{3, 2, 1, 2, 4, 6});
        longestIncreasingSubsequence(new int[]{3, 2, 1});
    }

    public static void longestIncreasingSubsequence(int[] inputArray) {
        int flag = 0;
        int maxSubarray = 1;
        int maxStart = 0, maxEnd = 0, start = 0, end = 0;
        int n = inputArray.length;
        boolean isIncreasing = false;

        int check = 0;
        System.out.println("Original array: " + Arrays.toString(inputArray));

      //  do {
            for (int i = 1; i < n; i++) {
                if (inputArray[i - 1] < inputArray[i]) {
                    isIncreasing = true;
                    if (flag != 1) {
                        start = i - 1;
                        flag = 1;
                    }
                    if (i == n - 1) {
                        end = n - 1;
                    }
                } else {
//                    isIncreasing = false;
                    if (flag == 1) {
                        end = i - 1;
                        flag = 0;
                    }
                }
                if (maxSubarray <= end - start && (isIncreasing)) {
                    maxSubarray = end - start;
                    maxStart = start;
                    maxEnd = end;
                    isIncreasing = false;

                    System.out.println();
                    for (int j = maxStart; j <= maxEnd; j++) {
                        System.out.print(" " + inputArray[j]);
                    }
                }
            }
//            i = maxEnd;
//            check++;
//        } while (check != n);

//        System.out.println(maxSubarray);
        System.out.println();
        System.out.println("Starting index = " + maxStart + " Ending index = " + maxEnd);
    }
}