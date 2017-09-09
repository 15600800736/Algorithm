package classic.dp;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class LongestCommonSubSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] dp = new int[n][m];
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (flag) {
                dp[i][0] = 1;
            } else {
                if (a[i] == b[0]) {
                    dp[i][0] = 1;
                    flag = true;
                } else {
                    dp[i][0] = 0;
                }
            }
        }
        flag = false;
        for (int i = 0; i < m; i++) {
            if (flag) {
                dp[0][i] = 1;
            } else {
                if (b[i] == a[0]) {
                    dp[0][i] = 1;
                    flag = true;
                } else {
                    dp[0][i] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = a[i] == b[j] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
