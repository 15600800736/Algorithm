package sort;

import java.util.Arrays;

/**
 * Created by fdh on 2017/8/25.
 */
public class MergeSort {
    public void merge(int[] integers, int low, int high) {
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


    public static void main(String[] args) {
        int[] a = new int[]{3,1,5,9,6,11,3,2,3,4,5,6,1,3,5,7};
        new MergeSort().merge(a,0, a.length);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
