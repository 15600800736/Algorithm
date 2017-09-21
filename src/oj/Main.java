package oj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by fdh on 2017/9/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        Integer[] merged = new Integer[n + m];
        int i = 0,j = 0,k = 0;
        while (i < a.length || j < b.length) {
            if (j >= b.length || (i < a.length && j < b.length && a[i] < b[j])) {
                merged[k++] = a[i++];
                continue;
            }
            if (i >= a.length || (i < a.length && j < b.length && a[i] > b[j])) {
                merged[k++] = b[j++];
                continue;
            }
            if (i < a.length && j < b.length && a[i] == b[j]) {
                merged[k++] = a[i++];
                j++;
            }
        }
        int c = 0;
        while (c < merged.length) {
            if (merged[c] == null) {
                break;
            }
            c++;
        }
        if (c != 0 && c % 2 == 0) {
            float result = ((float)merged[c/2] + merged[c/2 - 1]) / 2;
            System.out.println(result);
        } else if (c % 2 == 1){
            System.out.println(merged[c/2]);
        } else {
            System.out.println(0);
        }

    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Set<Integer> set = new HashSet<>();
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            set.add(scanner.nextInt());
//        }
//        int m = scanner.nextInt();
//        for (int i = 0; i < m; i++) {
//            set.add(scanner.nextInt());
//        }
//        Integer[] merged = set.toArray(new Integer[0]);
//        merge(merged, 0, merged.length);
//        int c = set.size();
//        if (c != 0 && c % 2 == 0) {
//            float result = ((float) merged[c / 2] + merged[c / 2 - 1]) / 2;
//            System.out.println(result);
//        } else if (c % 2 == 1) {
//            System.out.println(merged[c / 2]);
//        } else {
//            System.out.println(0);
//        }
//
//    }
//
//    public static void merge(Integer[] integers, int low, int high) {
//        if (high - low < 2) {
//            return;
//        }
//        int mid = (high + low) >> 1;
//        merge(integers, low, mid);
//        merge(integers, mid, high);
//
//        Integer[] temp = Arrays.copyOfRange(integers, low, mid);
//        for (int i = low, j = 0, k = mid; i < high; i++) {
//            if (j >= mid - low || (j < mid - low && k < high && integers[k] < temp[j])) {
//                integers[i] = integers[k++];
//                continue;
//            }
//            if (k >= high || (j < mid - low && k < high && integers[k] >= temp[j])) {
//                integers[i] = temp[j++];
//            }
//        }
//    }
}