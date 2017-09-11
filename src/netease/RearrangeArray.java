package netease;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/12.
 */
public class RearrangeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] ints = new int[n];
            for (int j = 0; j < n; j++) {
                ints[j] = scanner.nextInt();
            }
            int two = 0;
            int four = 0;
            int others = 0;

            for (int j = 0; j < n; j++) {
                if (ints[j] % 4 == 0) {
                    four++;
                } else if (ints[j] % 2 == 0) {
                    two++;
                } else {
                    others++;
                }
            }

            if (two == 0) {
                if (four > others - 2) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                if (four > others - 1) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
