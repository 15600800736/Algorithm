package jingdong;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class LuckyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = 0;
        for (int i = 1; i < n + 1; i++) {
            int o = getDigitSum(i, 10);
            int b = getDigitSum(i, 2);
            if (o == b) {
                num++;
            }
        }
        System.out.println(num);
    }

    private static int getDigitSum(int n, int scale) {
        int sum = 0;
        int tmp = n;
        while (tmp != 0) {
            int t = tmp / scale;
            int re = tmp - t * scale;
            sum += re;
            tmp /= scale;
        }
        return sum;
    }
}
