package az.mm.spiralmatrix;

import java.util.Scanner;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class Main4 {
    static int n;
    static int k; 
    int a=0;
    int[][] matrix;
    
    Main4(){
        matrix = new int[n][k];
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Olchunu daxil edin: ");
        n = sc.nextInt();
        k = sc.nextInt();
        
    Main4 m = new Main4();
        m.fillMatrix();
        m.printMatrix();
    }
 
    private  void fillMatrix(){
        int positionX = k / 2; // The middle of the matrix
        int positionY = n % 2 == 0 ? (n / 2) - 1 : (n / 2);
        
//        int left = (column%2 == 0) ? (column/2 - 1) : (column/2);
//        int top = (row%2 == 0) ? (row/2 - 1) : (row/2);
 
        int direction = 0; // The initial direction is "down"
        int stepsCount = 1; // Perform 1 step in current direction
        int stepPosition = 0; // 0 steps already performed
        int stepChange = 0; // Steps count changes after 2 steps
 
        
        for (int j = 0; j < n*k; j++){
            // Fill the current cell with the current value
            print(positionY, positionX);
 
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
//                case 0: positionY++; break;
//                case 1: positionX--; break;
//                case 2: positionY--; break;
//                case 3: positionX++; break;
                    
                case 0: positionY++; break;
                case 1: positionX--; break;
                case 2: positionY--; break;
                case 3: positionX++; break;
            }
        }
    }
    
    boolean print(int i, int j){
        if (i<0 || i>=n || j<0 || j>=k) return false;
        matrix[i][j] = a++;
        return true;
    }
 
 
    private void printMatrix(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < k; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }
}
