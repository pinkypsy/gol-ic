package ua.alvin.procedural;

// Java program to find length of the
// longest increasing subsequence
// whose adjacent element differ by 1

import java.util.*;
class LICS {
    static int LongIncrConseqSubseq(int arr[], int n)
    {
        // create hashmap to save latest consequent
        // number as "key" and its length as "value"
        HashMap<Integer, Integer> map = new HashMap<>();

        // put first element as "key" and its length as "value"
        map.put(arr[0], 1);
        for (int i = 1; i < n; i++) {

            // check if last consequent of arr[i] exist or not
            if (map.containsKey(arr[i] - 1)) {

                // put the updated consequent number
                // and increment its value(length)
                map.put(arr[i], map.get(arr[i] - 1) + 1);

                // remove the last consequent number
                map.remove(arr[i] - 1);
            }

            // if their is no last consequent of
            // arr[i] then put arr[i]
            else {
                map.put(arr[i], 1);
            }
        }
        return Collections.max(map.values());
    }

    // driver code
    public static void main(String args[])
    {
        // Take input from user
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(LongIncrConseqSubseq(arr, n));
    }
}
// This code is contributed by CrappyDoctor
