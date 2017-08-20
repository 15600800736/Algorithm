package others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fdh on 2017/8/20.
 */
public class TwoCPU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer[] tasks = new Integer[n];
        for (Integer i = 0; i < n; i++) {
            tasks[i] = scanner.nextInt();
        }
        int c = 0;
        for(int i = 0; i < n; i++) {
            c += tasks[i];
        }
        int ca = c >> 1;

        int[] dp = new int[ca + 1];
        for(int i = 0; i < n; i++) {
            for(int j = ca; j >= tasks[i]; j--) {
                if(dp[j] < dp[j - tasks[i]] + tasks[i]) {
                    dp[j] = dp[j - tasks[i]] + tasks[i];
                }
            }
        }
        System.out.println(c - dp[ca]);

    }
}