package jingdong;

import java.util.*;

/**
 * Created by fdh on 2017/9/9.
 */
public class Union {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<Integer> set = new HashSet<>(n + m);
        for (int i = 0; i < n + m; i++) {
            set.add(scanner.nextInt());
        }
        Integer[] integers = set.toArray(new Integer[0]);
        sort(integers, 0, integers.length);
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i]);
            if (i != integers.length - 1) {
                System.out.print(" ");
            }
        }
    }

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
}
