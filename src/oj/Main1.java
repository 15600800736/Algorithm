package oj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fdh on 2017/9/21.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = 0;
        }
        merge(ints, 0, ints.length);
        int min = ints[0] + s;
        int max = ints[ints.length - 1] - s;
        if (min > max) {
            max = max ^ min;
            min = min ^ max;
            max = max ^ min;
        }
        for (int i = 2; i < ints.length - 1; i++) {
            int a = ints[i] - s;
            int b = ints[i] + s;
            if (a >= min || b <= max) {
                continue;
            }

        }

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
