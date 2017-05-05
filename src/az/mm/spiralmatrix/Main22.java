package az.mm.spiralmatrix;

import java.util.Scanner;
/**
 * @author MM <mushfiqazeri@gmail.com>
 */
public class Main22 {
    private static int row;
    private static int column;
    private int[][] matrix;
    private boolean isClockwise = true;

    public Main22() {
        createMatrix();
    }

    public static void main(String[] args) {
        System.out.println("Please enter matrix lengths (example 4 3):");

        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        column = sc.nextInt();
        new Main22().start();
    }

    private void start() {
        int top = (row%2 == 0) ? (row/2 - 1) : (row/2);
        int bottom = top + 1;
        int d[], left, right;
        if (isClockwise) {
            left = (column%2 == 0) ? (column/2 - 1) : (column/2);
            right = left + 1;
            d = new int[]{left, top, right, bottom};
        } else {
            right = column/2;
            left = right - 1;
            d = new int[]{right, top, left, bottom};
        }
        int[][] s = {{1, 0, 2}, {1, 2, 3}, {3, 2, 0}, {3, 0, 1}};  //steps

        LOOP: while (true) 
            for (int i = 0; i < d.length; i++) {
                if (print(d[s[i][0]], d[s[i][1]], d[s[i][2]], i) == -1) break LOOP;
                d[i] = isClockwise ? (i==0 || i==1) ? --d[i] : ++d[i] : (i==1 || i==2) ? --d[i] : ++d[i];
            }
    }


    private int print(int i, int j, int end, int index) {
        if (i < 0 || i >= row || j < 0 || j >= column) return -1;
        System.out.print(matrix[i][j] + " ");
        if(isClockwise)
            switch (index) {
                case 0: if (++j >= end) return 0; break;
                case 1: if (++i >= end) return 0; break;
                case 2: if (--j <= end) return 0; break;
                case 3: if (--i <= end) return 0; break;
            }
        else
            switch (index) {
                case 0: if (--j <= end) return 0; break;
                case 1: if (++i >= end) return 0; break;
                case 2: if (++j >= end) return 0; break;
                case 3: if (--i <= end) return 0; break;
            }

        return print(i, j, end, index);
    }
    
    
    private void createMatrix() {
        matrix = new int[row][column];
        int value = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) 
                System.out.print((matrix[i][j] = value++) + "\t");
            System.out.println();
        }
    }
}




        
/* 
    switch (index) {
        case 0: if (isClockwise){if(++j>=end){return 0;}}
                else{if(--j<=end) {return 0;}}
                break;
        case 1: if (isClockwise){if(++i>=end){return 0;}}
                else{if(++i>=end){return 0;}}
                break;
        case 2: if (isClockwise){if(--j<=end){return 0;}}
                else{if(++j>=end) {return 0;}}
                break;
        case 3: if (isClockwise){if(--i<=end){return 0;}}
                else{if(--i<=end) {return 0;}}
                break;
    }
*/