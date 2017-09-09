package didi;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class SubArrayOfSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = scanner.nextInt();
        Integer sum = scanner.nextInt();
        int[] arr = new int[n];
        for (Integer i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        long[][] dp = new long[n][sum + 1];
        for (Integer i = 0; i < sum; i++) {
            if (i == arr[0]) {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < sum + 1; j++) {
                long res = (j - arr[i] >= 0 ? dp[i - 1][j - arr[i]] : (arr[i] == j ? 1 : 0)) + dp[i - 1][j];
                dp[i][j] = res;
            }
        }
        System.out.println(dp[n - 1][sum]);
    }
}
