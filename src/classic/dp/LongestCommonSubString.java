package classic.dp;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class LongestCommonSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int[][] dp = new int[str1.length()][str2.length()];
        int max = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str2.charAt(0) == str1.charAt(i)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(0) == str2.charAt(i)) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                dp[i][j] = str1.charAt(i) == str2.charAt(j) ? dp[i - 1][j - 1] + 1 : 0;
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        System.out.println(max);
    }
}
