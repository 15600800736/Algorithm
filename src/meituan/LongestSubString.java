package meituan;

import java.util.Scanner;

/**
 * Created by fdh on 2017/8/16.
 */
public class LongestSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int m = s1.length();
        int n = s2.length();

        Integer[][] num = new Integer[m][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (s2.charAt(i) == s1.charAt(0)) {
                num[0][i] = 1;
                if (num[0][i] > max) {
                    max = num[0][i];
                }
            } else {
                num[0][i] = 0;
            }

        }
        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                num[i][0] = 1;
                if (num[i][0] > max) {
                    max = num[i][0];
                }
            } else {
                num[i][0] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                num[i][j] = s1.charAt(i) == s2.charAt(j) ? num[i - 1][j - 1] + 1 : 0;
                if(num[i][j] > max) {
                    max = num[i][j];
                }
            }
        }

        System.out.println(max);


    }
}
