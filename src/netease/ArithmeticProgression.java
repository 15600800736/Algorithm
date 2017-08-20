package netease;

import java.util.*;

/**
 * Created by fdh on 2017/8/13.
 */
public class ArithmeticProgression {
    public static void main(String... strings) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        Integer[] list = new Integer[n];
        for (Integer i = 0; i < n; i++) {
            list[i] = (scanner.nextInt());
        }
        if(1 == n) {
            System.out.println("Possible");
        }
        ArithmeticProgression.sort(list,0, n);
        int first = list[0];
        int second = list[1];
        int d = second - first;
        int last = second;
        for (int i = 2; i < n; i++) {
            int current = list[i];
            int diff = current - last;
            if (diff != d) {
                System.out.println("Impossible");
                return;
            }
            last = current;
        }
        System.out.println("Possible");


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
        for(int i = low; i < high; i++) {
            if(j >= mid - low || (j < mid && k < high && lowToMid[j] > list[k])) {
                list[i] = list[k];
                k++;
                continue;
            }
            if(k >= high || (k < high && j < mid && list[k] >= lowToMid[j])) {
                list[i] = lowToMid[j];
                j++;
            }
        }
    }
}
