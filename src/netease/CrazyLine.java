package netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fdh on 2017/8/14.
 */
public class CrazyLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] h = new Integer[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }
        CrazyLine.sort(h, 0, n);


        int result = 0;
        for (int i = 0; i < n / 2; i++) {
            if (i == n / 2 - 1) {
                result += h[i];
            } else {
                result += 2 * h[i];
            }
        }

        for (int i = n / 2; i < n; i++) {
            if (i == n / 2) {
                if(n % 2 == 0) {
                    result -= h[i];
                } else {
                    result += h[i];
                }
            } else {
                result -= 2 * h[i];
            }
        }
        System.out.println(result);
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
            if (j >= mid - low || (j < mid && k < high && lowToMid[j] < list[k])) {
                list[i] = list[k];
                k++;
                continue;
            }
            if (k >= high || (k < high && j < mid && list[k] <= lowToMid[j])) {
                list[i] = lowToMid[j];
                j++;
            }
        }
    }
}
