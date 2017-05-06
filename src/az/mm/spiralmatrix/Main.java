package az.mm.spiralmatrix;

import java.util.Scanner;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class Main {
    private static int row;
    private static int column;
    private int[][] matrix;

    public Main() {
        createMatrix();
    }

    public static void main(String[] args) {
        System.out.println("Please enter matrix lengths (example 4 3):");
        
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        column = sc.nextInt();
        Main m = new Main();
        m.spiralMatrixClockwise();
        m.spiralMatrixCounterClockwise();
    }

    private void spiralMatrixClockwise() {
        System.out.println("\nClockwise elements:");

        int left = (column%2 == 0) ? (column/2 - 1) : (column/2);
        int right = left + 1;
        int top = (row%2 == 0) ? (row/2 - 1) : (row/2);
        int bottom = top + 1;

        OUTER: while (true) {

            for (int i = left; i < right; i++) {
                if(!printElement(top, i)) break OUTER;
            }
            left--;

            for (int i = top; i < bottom; i++) {
                if(!printElement(i, right)) break OUTER;
            }
            top--;

            for (int i = right; i > left; i--) {
                if(!printElement(bottom, i)) break OUTER;
            }
            right++;

            for (int i = bottom; i > top; i--) {
                if(!printElement(i, left)) break OUTER;
            }
            bottom++;
        }
    }
    
    private void spiralMatrixCounterClockwise() {
        System.out.println("\n\nCounter Clockwise elements:");
        
        int right = column/2;
        int left = right - 1;
        int top = (row%2 == 0) ? (row/2 - 1) : (row/2);
        int bottom = top + 1;
        
        OUTER: while (true) {

            for (int i = right; i > left; i--) {
                if(!printElement(top, i)) break OUTER;
            }
            right++;

            for (int i = top; i < bottom; i++) {
                if(!printElement(i, left)) break OUTER;
            }
            top--;

            for (int i = left; i < right; i++) {
                if(!printElement(bottom, i)) break OUTER;
            }
            left--;
           
            for (int i = bottom; i > top; i--) {
                if(!printElement(i, right)) break OUTER;
            }
            bottom++;
        }
    }
    
    private boolean printElement(int i, int j) {
        if (i<0 || i>=row || j<0 || j>=column) return false;
        System.out.print(matrix[i][j] + " ");
       return true;
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
