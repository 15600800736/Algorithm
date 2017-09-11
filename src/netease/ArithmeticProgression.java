package netease;

import java.util.*;

/**
 * Created by fdh on 2017/8/13.
 */
public class ArithmeticProgression {

    private static void sort(Integer[] list, int low, int high) {
        // the single element is always sorted
        if (high - low < 2) {
            return;
        }
        int mid = (low + high) / 2;
        sort(list, low, mid);
        sort(list, mid, high);
        Integer[] lowToMid = Arrays.copyOfRange(list, low, mid);
        int j = 0;
        int k = mid;
        for (int i = low; i < high; i++) {
            if (j >= mid - low || (j < mid && k < high && lowToMid[j] > list[k])) {
                list[i] = list[k];
                k++;
                continue;
            }
            if (k >= high || (k < high && j < mid && list[k] >= lowToMid[j])) {
                list[i] = lowToMid[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 1, 5, 9, 6, 11, 3, 2, 3, 4, 5, 6, 1, 3, 5, 7};
        sort(a, 0, a.length);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
