package netease;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/19.
 */
public class TwoCore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt() >> 10;
            sum += ints[i];
        }
        int c = ((sum - 1) >> 1) + 1;
        int[][] dp = new int[n][c + 1];

        for (int i = 0; i < c + 1; i++) {
            if (ints[0] <= i) {
                dp[0][i] = ints[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                dp[i][j] = j - ints[i] < 0 ? dp[i - 1][j] : Math.max(dp[i - 1][j], dp[i - 1][j - ints[i]] + ints[i]);
            }
        }

        System.out.println(Math.max(dp[n - 1][c], sum - dp[n - 1][c]) << 10);

    }
}
