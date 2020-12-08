package ua.alvin.procedural;

// Java program to find length of the
// longest increasing subsequence
// whose adjacent element differ by
import java.util.HashMap;

class GFG1
{

    // function that returns the length of the
    // longest increasing subsequence
    // whose adjacent element differ by 1
    public static void longestSubsequence(int[] a,
                                          int n)
    {

        // stores the index of elements
        HashMap<Integer,
                Integer> mp = new HashMap<>();

        // stores the length of the longest
        // subsequence that ends with a[i]
        int[] dp = new int[n];

        int maximum = Integer.MIN_VALUE;

        // iterate for all element
        int index = -1;
        for(int i = 0; i < n; i++)
        {

            // if a[i]-1 is present before i-th index
            if (mp.get(a[i] - 1) != null)
            {

                // last index of a[i]-1
                int lastIndex = mp.get(a[i] - 1) - 1;

                // relation
                dp[i] = 1 + dp[lastIndex];
            }
            else
                dp[i] = 1;

            // stores the index as 1-index as we need to
            // check for occurrence, hence 0-th index
            // will not be possible to check
            mp.put(a[i], i + 1);

            // stores the longest length
            if (maximum < dp[i])
            {
                maximum = dp[i];
                index = i;
            }
        }

        // We know last element of sequence is
        // a[index]. We also know that length
        // of subsequence is "maximum". So We
        // print these many consecutive elements
        // starting from "a[index] - maximum + 1"
        // to a[index].
        for (int curr = a[index] - maximum + 1;
             curr <= a[index]; curr++)
            System.out.print(curr + " ");
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] a = { 3, 10, 3, 11, 4,
                5, 6, 7, 8, 12 };
        int n = a.length;
        longestSubsequence(a, n);
    }
}

