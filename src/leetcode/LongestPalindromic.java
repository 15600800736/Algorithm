package leetcode;

/**
 * Created by fdh on 2017/9/22.
 */
public class LongestPalindromic {
    public static void main(String[] args) {
        String s = "aabbaad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] max = new int[2];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                max[0] = i;
                max[1] = i + 1;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (j + i >= s.length()) {
                    break;
                }
                int k = j + i;
                dp[j][k] = dp[j + 1][k - 1] && s.charAt(j) == s.charAt(k);
                if (dp[j][k] && k - j > max[1] - max[0]) {
                    max[0] = j;
                    max[1] = k;
                }
            }
        }

        return s.substring(max[0], max[1] + 1);

    }

}
