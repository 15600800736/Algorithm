package oj;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int size = 6 * n;
        String[][] dp = new String[n][size];
        // 1
        for (int i = 0; i < size; i++) {
            if (i <= 5) {
                dp[0][i] = String.valueOf(1) + "/" + "6";
            } else {
                dp[0][i] = "0/6";
            }
        }
        // from 2 to n
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < size; j++) {
                if (j < i) {
                    dp[i][j] = "0/1";
                    continue;
                }
                if (dp[i][j] == null) {
                    dp[i][j] = "0/1";
                }
                for (int k = 1; k < 7; k++) {
                    if (j - k < 0) {
                        break;
                    }
                    dp[i][j] = add(dp[i][j], dp[i - 1][j - k]);
                }
                dp[i][j] = multi("1/6", dp[i][j]);
                dp[i][j] = simple(dp[i][j]);
            }
        }
        String result = "0/1";
        for (int i = x - 1; i < size; i++) {
            result = add(result, dp[n - 1][i]);
            result = simple(result);
        }
        String[] strings = result.split("/");
        if (strings[0].equals("0")) {
            System.out.println(0);
        } else if (strings[0].equals(strings[1])) {
            System.out.println(1);
        } else {
            System.out.println(result);
        }

    }

    private static String multi(String s1, String s2) {
        String[] f = s1.split("/");
        String[] s = s2.split("/");
        String child = String.valueOf(Integer.parseInt(f[0]) * Integer.parseInt(s[0]));
        String parent = String.valueOf(Integer.parseInt(f[1]) * Integer.parseInt(s[1]));
        return child + "/" + parent;
    }

    private static String add(String s1, String s2) {
        String[] f = s1.split("" +
                "/");
        String[] s = s2.split("/");
        String child = String.valueOf(Integer.parseInt(f[0]) * Integer.parseInt(s[1])
                                        + Integer.parseInt(s[0]) * Integer.parseInt(f[1]));
        String parent = String.valueOf(Integer.parseInt(f[1]) * Integer.parseInt(s[1]));
        return child + "/" + parent;
    }
    private static String simple(String str) {
        String[] s = str.split("/");
        int child = Integer.parseInt(s[0]);
        int parent = Integer.parseInt(s[1]);
        if (child == 0) {
            return "0/1";
        }
        if (child == parent) {
            return "1/1";
        }
        int a = parent, b = child;
        while (a % b != 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }

        return String.valueOf(child / b) + "/" + String.valueOf(parent / b);



    }
}