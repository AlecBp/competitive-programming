package vangelisthebatbearandthebubbleschallenge;

import java.util.Scanner;
// https://csacademy.com/ieeextreme-practice/task/979a09a0cd8c4e98dd0a690f39a55bd2/
/* @author AlecBp */

public class VangelisTheBatbearAndTheBubblesChallenge {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int t = 0; t < n; t++) {
            boolean loopDetected = false;
            int nodes = in.nextInt();
            int edges = in.nextInt();
            int n1, n2;
            int[][] table = new int[nodes][nodes];
            for (int i = 0; i < edges; i++) {
                n1 = in.nextInt();
                n2 = in.nextInt();
                // Eliminate self loops
                if (n1 == n2) {
                    loopDetected = true;
                }
                table[n1][n2] = 1;
                table[n2][n1] = 1;
            }
            printTable(table);
            findLoop(table);
        }
    }

    public static void findLoop(int[][] table) {
        int[] visited = new int[table.length];
        findLoop(table, visited, 0, 0, 0);
    }

    public static void findLoop(int[][] table, int[] visited, int nVisited, int prevNode, int currNode) {
        // Checks if the current node is in the visited stack, meaning that there is a loop
        for (int i = 0; i < nVisited; i++) {
            if (visited[i] == currNode) {
                System.out.println("1");
                return;
            }
        }
        // Check for options to go to
        for (int i = 0; i < table.length; i++) {
            if (i != currNode) {
                if (table[currNode][i] == 1) {
                    if (i != prevNode) {
                        visited[nVisited++] = currNode;
                        printArray(visited, nVisited);
                        findLoop(table, visited, nVisited, currNode, i);
                        nVisited--;
                    }
                }
            }
        }
    }

    public static void printTable(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("");
    }

}
