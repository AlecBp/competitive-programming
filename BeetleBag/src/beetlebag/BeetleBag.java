package beetlebag;

import java.util.Scanner;

// https://csacademy.com/ieeextreme-practice/task/ed8629419f140a5a2c923b049aba1224/
/* @author AlecBp */
public class BeetleBag {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int[] answers = new int[cases];
//         Loop for each case
        for (int t = 0; t < cases; t++) {
            int cap = in.nextInt();
            int nItems = in.nextInt() + 1;
            int[] ps = new int[nItems];
            int[] ws = new int[nItems];
            ps[0] = 0;
            ws[0] = 0;
//            Loop for each gadget
            for (int i = 1; i < nItems; i++) {
                ws[i] = in.nextInt();
                ps[i] = in.nextInt();
            }
//             Solve for case #i
            // Initialize 2D array of n+1 items to store calculations
            int[][] grid = new int[nItems][cap + 1];

            for (int i = 0; i < nItems; i++) {
                for (int j = 0; j < cap + 1; j++) {
                    if (i == 0 || j == 0) {
                        grid[i][j] = 0;
                    } else if (ws[i] <= j) {
                        grid[i][j] = Math.max(ps[i] + grid[i - 1][j - ws[i]], grid[i - 1][j]);
                    } else {
                        grid[i][j] = grid[i - 1][j];
                    }
                }
            }
//             Store result in answers array
            answers[t] = grid[nItems - 1][cap];
        }
        for (int i = 0; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
    }
}
