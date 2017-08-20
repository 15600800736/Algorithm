package meituan;

import java.util.Scanner;

/**
 * Created by fdh on 2017/8/14.
 */
public class Zillionaire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = scanner.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        Integer[] integers = new Integer[n];
        integers[0] = 1;
        for (int i = 1; i < integers.length; i++) {
            integers[i] = 0;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i;j++) {
                integers[i] += integers[j];
            }
            integers[i]++;
        }

        System.out.println(integers[n - 1]);

    }

}
