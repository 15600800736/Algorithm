package DiDi;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class MaxContinuousSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        int num = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (num + ints[i] < 0) {
                num = 0;
                if (num + ints[i] > max) {
                    max = num + ints[i];
                }
                continue;
            }
            num += ints[i];
            if (num > max) {
                max = num;
            }
        }

        System.out.println(max);
    }
}
