package az.mm.spiralmatrix;

import java.util.Scanner;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class Main22 {
    private static int row;
    private static int column;
    private int[][] matrix;
    private int[][] s;  //steps

    public Main22() {
        createMatrix();
    }

    public static void main(String[] args) {
        System.out.println("Please enter matrix lengths (example 4 3):");

        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        column = sc.nextInt();
        Main22 m = new Main22();
        m.spiralMatrixClockwise();
        m.spiralMatrixCounterClockwise();
  
    }

    private void spiralMatrixClockwise() {
        System.out.println("\nClockwise elements:");

        int left = (column % 2 == 0) ? (column / 2 - 1) : (column / 2);
        int right = left + 1;
        int top = (row % 2 == 0) ? (row / 2 - 1) : (row / 2);
        int bottom = top + 1;

        int[] d = {left, top, right, bottom};
        int[][] s = {{1, 0, 2}, {1, 2, 3}, {3, 2, 0}, {3, 0, 1}};

        LOOP: while (true) 
            for (int i = 0; i < d.length; i++) {
                if (printClockwise(d[s[i][0]], d[s[i][1]], d[s[i][2]], i) == -1) break LOOP;
                if (i==0 || i==1) d[i]--; else d[i]++;
            }
    }


    private int printClockwise(int i, int j, int end, int index) {
        if (i < 0 || i >= row || j < 0 || j >= column) return -1;
        System.out.print(matrix[i][j] + " ");
        switch (index) {
            case 0: j++; if (j >= end) return 0; break;
            case 1: i++; if (i >= end) return 0; break;
            case 2: j--; if (j <= end) return 0; break;
            case 3: i--; if (i <= end) return 0; break;
        }

        return printClockwise(i, j, end, index);
    }
    
    
    private void spiralMatrixCounterClockwise() {
        System.out.println("\n\nCounter Clockwise elements:");

        int right = column/2;
        int left = right - 1;
        int top = (row%2 == 0) ? (row/2 - 1) : (row/2);
        int bottom = top + 1;

        int[] d = {right, top, left, bottom};
        int[][] s = {{1, 0, 2}, {1, 2, 3}, {3, 2, 0}, {3, 0, 1}};

        LOOP: while (true) 
            for (int i = 0; i < d.length; i++) {
                if (printCounterClockwise(d[s[i][0]], d[s[i][1]], d[s[i][2]], i) == -1) break LOOP;
                if (i==1 || i==2) d[i]--; else d[i]++;
            }
    }


    private int printCounterClockwise(int i, int j, int end, int index) {
        if (i < 0 || i >= row || j < 0 || j >= column) return -1;
        System.out.print(matrix[i][j] + " ");
        switch (index) {
            case 0: j--; if (j <= end) return 0; break;
            case 1: i++; if (i >= end) return 0; break;
            case 2: j++; if (j >= end) return 0; break;
            case 3: i--; if (i <= end) return 0; break;
        }

        return printCounterClockwise(i, j, end, index);
    }
    

    
    
    private void createMatrix() {
        matrix = new int[row][column];
        int value = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print((matrix[i][j] = value++) + "\t");
            }
            System.out.println();
        }
    }
}
