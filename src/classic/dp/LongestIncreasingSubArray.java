package classic.dp;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class LongestIncreasingSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        int max = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = ints[i] > ints[i - 1] ? dp[i - 1] + 1 : 1;
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
