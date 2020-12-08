package ua.alvin.procedural;

public class Solution {
    public static void main(String[] args) {

        int[][] A = {
                {1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 1}};

        int cnt = 0;
        int cur_cnt = 0;



        for(int x=0; x<A.length; x++) {
            for(int y=0; y<A[x].length; y++) {
                if (A[x][y] == 1) {
                    cur_cnt = 0;
                    cnt = cnt + clean_block(A,x,y, cur_cnt);
                }
            }
        }

        System.out.println(cnt);
    }

    public static int clean_block(int[][] A, int x_in, int y_in, int cur_cnt) {
        A[x_in][y_in] = 0;
        if (coordinate_exists(x_in-1,y_in  , A.length, A[0].length) == 1 && A[x_in-1][y_in  ] == 1) {clean_block(A,x_in-1,y_in  ,cur_cnt); cur_cnt = 1;}
        if (coordinate_exists(x_in+1,y_in  , A.length, A[0].length) == 1 && A[x_in+1][y_in  ] == 1) {clean_block(A,x_in+1,y_in  ,cur_cnt); cur_cnt = 1;}
        if (coordinate_exists(x_in  ,y_in-1, A.length, A[0].length) == 1 && A[x_in  ][y_in-1] == 1) {clean_block(A,x_in  ,y_in-1,cur_cnt); cur_cnt = 1;}
        if (coordinate_exists(x_in  ,y_in+1, A.length, A[0].length) == 1 && A[x_in  ][y_in+1] == 1) {clean_block(A,x_in  ,y_in+1,cur_cnt); cur_cnt = 1;}

        return cur_cnt;
    }

    public static int coordinate_exists(int x_in, int y_in, int A_x_length, int A_y_length) {
        if (x_in >= 0 && x_in <= (A_x_length-1) && y_in >= 0 && y_in <= (A_y_length-1)) {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}