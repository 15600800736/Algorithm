package classic.dp;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class MaxSumOfSubSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = num < 0 ? ints[i] : num + ints[i];
            if (num > max) {
                max = num;
            }
        }
        System.out.println(max);
    }
}
