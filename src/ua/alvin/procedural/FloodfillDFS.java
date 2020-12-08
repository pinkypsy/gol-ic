package ua.alvin.procedural;

import java.util.HashMap;
import java.util.Map;

public class FloodfillDFS {
    static Map<Integer, Integer> result = new HashMap<>();
    static int size = -1;
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 1}};
       /* int[][] grid = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0}};*/
        System.out.println(countIslands(grid));
        gridState(grid);

        System.out.println(size/4);

    }

    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result++;
                    doFill(grid, i, j);
                }
            }
        }
        return result;
    }

    public static void doFill(int[][] grid, int row, int col) {
        size++;
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0;
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        for (int i = 0; i < dr.length; i++) {
            doFill(grid, row + dr[i], col + dc[i]);
        }
    }

    static void gridState(int[][] grid) {
        System.out.println("Grid:");
        for (int line = 0; line < grid.length; line++) {
            for (int column = 0; column < grid[line].length; column++) {
                System.out.print(" " + grid[line][column]);
            }
            System.out.println();
        }
    }
}
