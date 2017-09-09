package classic.dp;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class ZeroOneBag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        int c = scanner.nextInt();
        int[][] dp = new int[n][c + 1];
        for (int i = 0; i < c + 1; i++) {
            dp[0][i] = b[0] > i ? 0 : w[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                dp[i][j] = j - b[i] < 0 ? dp[i - 1][j]
                        : Math.max(dp[i - 1][j],dp[i - 1][j - b[i]] + w[i]);
            }
        }

        System.out.println(dp[n - 1][c]);
    }
}
