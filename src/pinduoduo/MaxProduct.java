package pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fdh on 2017/9/16.
 */
public class MaxProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n < 3) {
            return;
        }

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        int max = ints[0] * ints[1] * ints[2];
        merge(ints, 0, 3);
        int min1 = ints[0];
        int min2 = ints[1];
        int max2 = ints[1];
        int max1 = ints[2];
        for (int i = 3; i < n; i++) {
            int[] products = new int[6];
            products[0] = ints[i] * max1 * max2;
            products[1] = ints[i] * max1 * min1;
            products[2] = ints[i] * max1 * min2;
            products[3] = ints[i] * max2 * min1;
            products[4] = ints[i] * max2 * min2;
            products[5] = ints[i] * min1 * min2;

            merge(products, 0, 6);
            max = Math.max(max, products[5]);
            if (ints[i] > max1) {
                max1 = ints[i];
            } else if (ints[i] > max2) {
                max2 = ints[i];
            }

            if (ints[i] < min1) {
                min1 = ints[i];
            } else if (min2 < ints[i]) {
                min2 = ints[i];
            }
        }
        System.out.println(max);
    }

    public static void merge(int[] integers, int low, int high) {
        if (high - low < 2) {
            return;
        }
        int mid = (high + low) >> 1;
        merge(integers, low, mid);
        merge(integers, mid, high);

        int[] temp = Arrays.copyOfRange(integers, low, mid);
        for (int i = low, j = 0, k = mid; i < high; i++) {
            if (j >= mid - low || (j < mid - low && k < high && integers[k] < temp[j])) {
                integers[i] = integers[k++];
                continue;
            }
            if (k >= high || (j < mid - low && k < high && integers[k] >= temp[j])) {
                integers[i] = temp[j++];
            }
        }
    }
}
