package matrixchainmultiplication;

import java.util.Scanner;
import java.lang.Math;

/**
 * @author Alec
 */
public class MatrixChainMultiplication {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of matrices: ");
        int numMatrices = in.nextInt();

        System.out.println("For every matrix enter the number of rows and columns, separated by a space");
        int[][] matrices = new int[2][numMatrices];
        for (int i = 0; i < numMatrices; i++) {
            System.out.print("Enter size of matrix [" + i + "]: ");
            // Row
            matrices[0][i] = in.nextInt();
            // Column
            matrices[1][i] = in.nextInt();
        }
        print2DArray(matrices);

        int[][] calculations = new int[numMatrices][numMatrices];
        // Fill diagonal with 0 and rest with Integer.MAX_VALUE
        for (int i = 0; i < numMatrices; i++) {
            for (int j = i; j < numMatrices; j++) {
                if (i == j) {
                    calculations[i][j] = 0;
                }else{
                    calculations[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < numMatrices - 1; i++) {
            getNumCalculations(i, i + 1, matrices, calculations); // 0,1 | 1,2 | 2,3
        }

        print2DArray(calculations);
    }

    public static int getNumCalculations(int m1, int m2, int[][] matrices, int[][] calculations) {
        if (m1 <= m2) {
            return 0;
        }
        if (matrices[m1][m2] != 0) {
            return calculations[m1][m2];
        }
        // M1rows *  (M1cols = M2rows) * M2cols
        int calc = matrices[0][m1] * matrices[1][m1] * matrices[1][m2];
        if (calc < calculations[m1][m2]) {
            calculations[m1][m2] = calc;
        }
        return getNumCalculations(m1 + 1, m2 - 1, matrices, calculations);
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
