package coinchange;

import java.util.Arrays;
import java.util.Scanner;

/* @author AlecBp */
public class CoinChange {

    public static void main(String[] args) {
        int[] denominators;
        int numDenominators;
        int[][] table;
        int amount;
        Scanner in = new Scanner(System.in);

        System.out.print("Amount to change: ");
        amount = in.nextInt();
        System.out.print("Number of denominators: ");
        numDenominators = in.nextInt();
        denominators = new int[numDenominators];
        table = new int[numDenominators + 1][amount + 1];

        for (int i = 0; i < numDenominators; i++) {
            System.out.print("Enter denominators [" + i + "]: ");
            denominators[i] = in.nextInt();
        }

        Arrays.sort(denominators);
        // Fill top row
        for (int i = 0; i < amount + 1; i++) {
            table[0][i] = amount + 1;
        }
        table[0][0] = 0;

        int usePos, coin;
        for (int row = 1; row < numDenominators + 1; row++) {
            coin = denominators[row - 1];
            for (int amt = 0; amt < amount + 1; amt++) {
                if (amt - coin >= 0) {
                    usePos = table[row][amt - coin] + 1;
                    if (usePos < table[row - 1][amt]) {
                        table[row][amt] = usePos;
                    } else {
                        table[row][amt] = table[row - 1][amt];
                    }
                } else {
                    if (row == 1) {
                        table[row][amt] = 0;
                    } else {
                        table[row][amt] = table[row - 1][amt];
                    }
                }
            }
        }
        print(table);
        int input = 0;
        while (input != -1) {
            System.out.print("Get change for (must be <= " + amount + " and >= 0): ");
            input = in.nextInt();
            if (input >= 0 && input <= amount) {
                getCoins(table, denominators, numDenominators, input);
            }
            System.out.println("");
        }
    }

    public static void getCoins(int[][] table, int[] denominators, int row, int col) {
        if (row == 0 && col == 0) {
            return;
        } else if (table[row][col] == table[row - 1][col]) {
            getCoins(table, denominators, row - 1, col);
        } else {
            System.out.print(denominators[row - 1] + " ");
            getCoins(table, denominators, row, col - denominators[row - 1]);
        }
    }

    public static void print(int[][] tbl) {
        for (int i = 0; i < tbl.length; i++) {
            for (int j = 0; j < tbl[0].length; j++) {
                System.out.print(tbl[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
