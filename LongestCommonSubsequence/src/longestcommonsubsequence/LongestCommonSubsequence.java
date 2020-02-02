package longestcommonsubsequence;

import java.util.Scanner;

/* @author AlecBp */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a;
        String b;
        char[] arr1;
        char[] arr2;
        int[][] table;

        System.out.print("Enter sequence 1: ");
        a = in.next();
        arr1 = a.toCharArray();
        System.out.print("Enter sequence 2: ");
        b = in.next();
        arr2 = b.toCharArray();
        table = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        printTable(table);
        printCharacters(table, arr1, arr2, arr1.length, arr2.length);
        System.out.println("");
    }

    public static void printCharacters(int[][] table, char[] a, char[] b, int row, int col) {
        int curr = table[row][col];
        if (row == 0 && col == 0) {
            return;
        } else if (curr == table[row - 1][col]) {
            printCharacters(table, a, b, row - 1, col);
        } else if (curr == table[row][col - 1]) {
            printCharacters(table, a, b, row, col - 1);
        } else {
            printCharacters(table, a, b, row - 1, col - 1);
            System.out.print(b[col - 1] + " ");
        }
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public static void printTable(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
