package wangyiyoudao;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class Shuffle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] ints = new int[2 * n];
            int[] index = new int[2 * n];
            for (int j = 0; j < 2 * n; j++) {
                ints[j] = scanner.nextInt();
                index[j] = j;
            }

            for (int j = 0; j < 2 * n; j++) {
                for (int l = 0; l < k; l++) {
                    if (index[j] >= n) {
                        index[j] = (2 * n - 1) - 2 * (2 * n - 1 - index[j]);
                    } else {
                        index[j] *= 2;
                    }
                }
            }

            int[] newInts = new int[2 * n];
            for (int j = 0; j < 2 * n; j++) {
                newInts[index[j]] = ints[j];
            }
            for (int j = 0; j < 2 * n; j++) {
                System.out.print(newInts[j]);
                if (j == 2 * n - 1) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
