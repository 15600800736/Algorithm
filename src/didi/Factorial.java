package didi;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = 0;
        for (int i = 1; i < n + 1; i++) {
            int temp = i;
            while (temp % 5 == 0) {
                temp /= 5;
                num++;
            }
        }
        System.out.println(num);
    }
}
