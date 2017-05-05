/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.mm.spiralmatrix;

import java.util.Scanner;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class Main3 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Olchunu daxil edin: ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
 
        fillMatrix(matrix, n);
        printMatrix(matrix, n);
    }
 
    private static void fillMatrix(int[][] matrix, int n){
        int positionX = n / 2; // The middle of the matrix
        int positionY = n % 2 == 0 ? (n / 2) - 1 : (n / 2);
 
        int direction = 0; // The initial direction is "down"
        int stepsCount = 1; // Perform 1 step in current direction
        int stepPosition = 0; // 0 steps already performed
        int stepChange = 0; // Steps count changes after 2 steps
 
        for (int i = 0; i < n * n; i++){
            // Fill the current cell with the current value
            matrix[positionY][positionX] = i;
 
            // Check for direction / step changes
            if (stepPosition < stepsCount){
                stepPosition++;
            } else {
                stepPosition = 1;
                if (stepChange == 1){
                    stepsCount++;
                }
                stepChange = (stepChange + 1) % 2;
                direction = (direction + 1) % 4;
            }
 
            // Move to the next cell in the current direction
            switch (direction){
                case 0: positionY++; break;
                case 1: positionX--; break;
                case 2: positionY--; break;
                case 3: positionX++; break;
            }
        }
    }
 
 
    private static void printMatrix(int[][] matrix, int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }
    
}