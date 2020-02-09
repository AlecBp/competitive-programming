package vangelisthebatbearandthebubbleschallenge;

import java.util.Scanner;
// https://csacademy.com/ieeextreme-practice/task/979a09a0cd8c4e98dd0a690f39a55bd2/
/* @author AlecBp */

public class VangelisTheBatbearAndTheBubblesChallenge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes, edges, n1, n2, n;
        boolean hasLoop;
        int[][] table;
        n = in.nextInt();

        for (int t = 0; t < n; t++) {
            hasLoop = false;
            nodes = in.nextInt();
            edges = in.nextInt();
            table = new int[nodes][nodes];

            for (int i = 0; i < edges; i++) {
                n1 = in.nextInt();
                n2 = in.nextInt();
                // Check for self loops
                if (n1 == n2) {
                    hasLoop = true;
                }
                table[n1][n2] = 1;
                table[n2][n1] = 1;
            }

            // If there was a self loop in the input, print 0 and go to next
            if (!hasLoop) {
                if (findLoop(table)) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else {
                System.out.println("1");
            }
        }
    }

    public static boolean findLoop(int[][] table) {
        boolean[] visited = new boolean[table.length];
        for (int i = 0; i < table.length; i++) {
            if (findLoop(table, visited, i, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean findLoop(int[][] table, boolean[] visited, int prevNode, int currNode) {
        // Checks if the current node is in the visited stack, meaning that there is a loop
        if (visited[currNode]) {
            return true;
        }
        // Mark current node as visited
        visited[currNode] = true;
        // Check for options to go to
        for (int i = 0; i < table.length; i++) {
            // Must be different than self
            if (i != currNode) {
                // Must be connected to that node
                if (table[currNode][i] == 1) {
                    // Must be different than the previous node
                    if (i != prevNode) {
                        // System.out.println("FROM " + currNode + " TO " + i);
                        if (findLoop(table, visited, currNode, i)) {
                            return true;
                        }
                    }
                }
            }
        }
        // Mark current node as not visited
        visited[currNode] = false;
        return false;
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
