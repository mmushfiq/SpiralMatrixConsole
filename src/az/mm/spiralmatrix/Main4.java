package az.mm.spiralmatrix;

import java.util.Scanner;

/**
 * @author MM <mushfiqazeri@gmail.com>
 */
public class Main4 {
    private static int row, col, matrix[][], maxCenter, centerN;
    private static final boolean isClockwise = false;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\nPlease enter matrix lengths (example 4 3):");
            row = sc.nextInt();
            col = sc.nextInt();
            matrix = new int[row][col];
            maxCenter = (row%2==0 && col%2==0) ? 4 : (row%2==0 || col%2==0) ? 2 : 1;
            if (maxCenter != 1){ 
                System.out.println("Please enter center element number: 1 - " + maxCenter);
                centerN = sc.nextInt();
            }
            start();
        }
    }
 
    private static void start(){
        System.out.println(isClockwise ? "Clockwise:" : "Counter-Clockwise");
        int i=row/2, j=col/2;
        if(maxCenter > 1){ 
            if((row%2 == 0 && centerN==1) || (maxCenter>2 && centerN==2)) i=row/2-1; 
            if((col%2 == 0 && centerN==1) || (maxCenter>2 && centerN==3)) j=col/2-1;
        }
        int direction=0, steps=1, currentStep=0, change=0; 
 
        for (int a = 1; a <= row*col; a++){
            if (i<0 || i>=row || j<0 || j>=col) a--;        
            else matrix[i][j] = a;
            
            if (currentStep < steps) 
                currentStep++;
            else {
                currentStep = 1;
                if (change == 1) steps++;
                change = (change+1) % 2;
                direction = (direction+1) % 4;
            }
            
            switch (direction){
                case 0: if(isClockwise) j++; else j--; break;
                case 1: i++; break;
                case 2: if(isClockwise) j--; else j++; break;
                case 3: i--; break;
            }
        }
        printMatrix();
    }
    
    private static void printMatrix(){
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }
}
