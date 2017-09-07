package toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fdh on 2017/9/7.
 */
public class Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        sort(ints, 0, n);
        int i = 0;
        int num = 0;
        while (i < n) {
            if (i + 1 < n) {
                if (ints[i + 1] - ints[i] > 10) {
                    i  = i + 1;
                    num += 2;
                } else {
                    if (i + 2 < n) {
                        if (ints[i + 2] - ints[i + 1] > 10) {
                            num += 1;
                            i += 2;
                        } else {
                            i += 3;
                        }
                    } else {
                        num += 1;
                        i = n;
                    }
                }
            } else {
                num += 2;
                i = n;
            }
        }

        System.out.println(num);

    }

    private static void sort(int[] list, int low, int high) {
        // the single element is always sorted
        if (high - low < 2) {
            return;
        }
        int mid = (low + high) / 2;
        sort(list, low, mid);
        sort(list, mid, high);
        int[] lowToMid = Arrays.copyOfRange(list, low, mid);
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
