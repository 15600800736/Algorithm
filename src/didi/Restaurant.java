package didi;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class Restaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            int[] c = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < m; i++) {
                b[i] = scanner.nextInt();
                c[i] = scanner.nextInt();
            }


        }
    }

    private static void sort(int[] ints, int low, int high) {
        if (high == low) {
            return;
        }
        int index = partition(ints, low, high);
        sort(ints, low, index);
        sort(ints, index + 1, high);
    }

    private static int partition(int[] ints, int low, int high) {
        int index = rand(low, high);

        return 0;
    }

    private static void swap(int[] ints, int i, int j) {
        ints[i] = ints[i] ^ ints[j];
        ints[j] = ints[j] ^ ints[i];
        ints[i] = ints[i] ^ ints[j];
    }

    private static int rand(int low, int high) {
        if (high - low == 1) {
            return low;
        }
        int r = new Random().nextInt(high - 1) % (high - low) + low;
        return r;
    }
}
