package jingdong;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/8.
 */
public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String avg = average(i);
        System.out.println(avg);
    }

    private static String average(int n) {
        int s = 0;
        for (int i = 2; i < n; i++) {
            int sum = 0;
            int tmp = n;
            while (tmp != 0) {
                int t = tmp / i;
                int re = tmp - t * i;
                sum += re;
                tmp /= i;

            }
            s += sum;
        }
        int mcd = getMaxCommonDivisor(s, n - 2);
        return String.valueOf(s / mcd) + "/" + String.valueOf((n - 2) / mcd);
    }

    private static int getMaxCommonDivisor(int a, int b) {
        while (true) {
            int c = a % b;
            if (c == 0) {
                return b;
            }
            a = b;
            b = c;
        }
    }
}
