package az.mm.spiralmatrix;

import java.util.Scanner;

/**
 * @author MM <mushfiqazeri@gmail.com>
 * 
 * Alqoritmin işləmə məntiqi
 * Əsas 2 qanunauyğunluq var (saat əqrəbi istiqamətində):
 * 1. istiqamət üzrə - sağ->aşağı->sol->yuxarı təkrarlanır
 * 2. addımlar üzrə - hər iki istiqamətdən bir gediləcək addımların sayı 1 artır, yəni 1 sağ, 1 aşağı, 2 sol, 2 yuxarı, 3 sağ, 3 aşağı, 4 sol, 4 yuxarı və s. --> 1,1,2,2,3,3,4,4...
 * 
 * direction - istiqaməti bildirir, 0-sağ, 1-aşağı, 2-sol, 3-yuxarı
 * steps - cari istiqamət üzrə (direction) gediləcək addımların sayı
 * currentStep - ümumi addımlar içərisindən (steps) cari addımın nömrəsini bildirir, cari istiqamət üzrə gediləcək addımların bitib-bitməməsini yoxlamaq üçün istifadə edilir
 * change - istiqamətin dəyişib dəyişmədiyini yoxlayır, hər 2 istiqamət dəyişikliyindən sonra addımların sayını (steps) bir artırmaq üçün istifadə edilir 
 */
public class Main3 {
    private static int row, col, matrix[][];
    private static boolean isClockwise = true;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter matrix lengths (example 4 3):");
        row = sc.nextInt();
        col = sc.nextInt();
        createMatrix();
        printSpiralElements();
    }
 
    private static void printSpiralElements(){
        System.out.println(isClockwise ? "Clockwise:" : "Counter-Clockwise");
        int i = row%2 == 0 ? row/2-1 : row/2;
        int j = isClockwise ? col%2 == 0 ? col/2-1 : col/2 : col/2;
        int direction=0, steps=1, currentStep=0, change=0; 
 
        for (int a = 0; a < row*col; a++){
            if (i<0 || i>=row || j<0 || j>=col) break; //kvadrat olmayan matrislər üçün bu şərt vacibdir
            System.out.print(matrix[i][j]+" ");
 
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
    }
 
    private static void createMatrix() {
        matrix = new int[row][col];
        int value = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) 
                System.out.print((matrix[i][j] = value++) + "\t");
            System.out.println();
        }
    }
}
