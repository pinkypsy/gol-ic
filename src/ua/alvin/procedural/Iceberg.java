package ua.alvin.procedural;

import java.util.HashMap;
import java.util.Map;

public class Iceberg {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 1}};
        Map<Integer, Integer> result = new HashMap<>();

        for (int lineIndex = 0; lineIndex < grid.length - 1; lineIndex++) {

            if (grid[lineIndex][lineIndex] == 1) {
                for (int columnIndex = 0; columnIndex < grid[lineIndex].length - 1; columnIndex++) {
                    if (grid[lineIndex][columnIndex + 1] == 1) {
                        grid[lineIndex][columnIndex + 1] = 0;
                        grid[lineIndex][columnIndex]++;
                    } else if (grid[lineIndex + 1][columnIndex] == 1) {
                        grid[lineIndex + 1][columnIndex] = 0;
                        grid[lineIndex][columnIndex]++;
                    }


               /* if (grid[lineIndex][columnIndex] == 1) {
                    System.out.print(" " + grid[lineIndex][columnIndex]);

                }*/

                }
            }
        }
        gridState(grid);
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



/*
for (int line = 0; line < grid.length; line++) {
        for (int column = 0; column < grid[line].length; column++) {
        System.out.print(" " + grid[line][column]);
        }
        System.out.println();
        }*/
