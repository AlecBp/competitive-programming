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
        int[] simplified = new int[numMatrices + 1];

        for (int i = 0; i < numMatrices; i++) {
            System.out.print("Enter size of matrix [" + i + "]: ");
            // Row
            matrices[0][i] = in.nextInt();
            simplified[i] = matrices[0][i];
            // Column
            matrices[1][i] = in.nextInt();
        }
        // Add column of last matrix
        simplified[numMatrices] = matrices[1][numMatrices - 1];

        MatrixChain(simplified, numMatrices + 1);
    }

    public static void MatrixChain(int[] simplified, int numMat) {
        int i, j, k, chainLen, cost;

        int[][] calculations = new int[numMat][numMat];
        int[][] s = new int[numMat][numMat];

        // Fill diagonal with 0 and rest with a high value
        for (i = 0; i < numMat; i++) {
            for (j = i; j < numMat; j++) {
                if (i == j) {
                    calculations[i][j] = 0;
                } else {
                    calculations[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (chainLen = 2; chainLen < numMat; chainLen++) {
            for (i = 1; i < numMat - chainLen + 1; i++) {
                j = i + chainLen - 1;
                if (j == numMat) {
                    continue;
                }
                for (k = i; k <= j - 1; k++) {
                    cost = calculations[i][k] + calculations[k + 1][j] + simplified[i - 1] * simplified[k] * simplified[j];
                    if (cost < calculations[i][j]) {
                        calculations[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }

        System.out.println("\nCalculations");
        print2DArray(calculations);
        System.out.println("\nS table");
        print2DArray(s);
        System.out.println("\nOrder of operations: ");
        printOperations(s, 1, numMat - 1);
        System.out.println("\nNumber of calculations: " + calculations[1][numMat - 1]);
    }

    static void printOperations(int s[][], int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOperations(s, i, s[i][j]);
            printOperations(s, s[i][j] + 1, j);
            System.out.print(")");
        }
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
