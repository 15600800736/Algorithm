package netease;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/11.
 */
public class GetOppositeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = reverseNumber(n);
        System.out.println(r + n);
    }

    private static int reverseNumber(int n) {
        StringBuilder sb = new StringBuilder();
        reverse(n, sb);
        return Integer.parseInt(sb.toString());
    }

    private static void reverse(int n, StringBuilder sb) {
        int tmp = n;
        while (tmp != 0) {
            int t = tmp / 10;
            int i = tmp - t * 10;
            sb.append(i);
            tmp = t;
        }
    }
}
