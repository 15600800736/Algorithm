package meituan;

import java.util.Scanner;

/**
 * Created by fdh on 2017/8/14.
 */
public class Money {
    public static Integer[] kind = {1, 5, 10, 20, 50, 100};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = scanner.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }
        n++;
        Integer[][] num = new Integer[n][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                num[j][i] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            num[i][0] = 1;
        }


        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < n; j++) {
                int k = j / kind[i];
                for (int l = 0; l < k + 1; l++) {
                    num[j][1] += num[j - l * kind[i]][0];
                }
            }
            for(int j = 1; j < n; j++) {
                num[j][0] = num[j][1];
                num[j][1] = 0;
            }

        }
        System.out.println(num[n - 1][0]);
    }
}
