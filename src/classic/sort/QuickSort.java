package classic.sort;

import java.util.Random;

/**
 * Created by fdh on 2017/8/25.
 */
public class QuickSort {
    public void sort(int[] integers, int low, int high) {
        if (high <= low) {
            return;
        }
        int index = partitionII(integers, low, high);

        sort(integers, low, index);
        sort(integers, index + 1, high);

    }

    private int partitionII(int[] integers, int low, int high) {
        int index = rand(low,high);
        swap(integers, low, index);
        int temp = integers[low];
        high--;
        while(low < high) {
            while (low < high && integers[high] > temp) {
                high--;
            }
            if (low < high) {
                integers[low++] = integers[high];
            }

            while (low < high && integers[low] <= temp) {
                low++;
            }

            if (low < high) {
                integers[high--] = integers[low];
            }
        }
        integers[low] = temp;
        return low;

    }

    public void swap(int[] integers, int i, int j) {
        if (i > integers.length - 1 || j > integers.length - 1 || i == j) {
            return;
        }
        integers[i] = integers[i] ^ integers[j];
        integers[j] = integers[j] ^ integers[i];
        integers[i] = integers[i] ^ integers[j];
    }

    public int rand(int low, int high) {
        if (high - low == 1) {
            return low;
        }
        if (high - low > 1) {
            return new Random().nextInt(high - 1) % (high - low) + low;
        }
        return low;
    }



    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            int[] integers = new int[]{2, 13, 12, 1};
            new QuickSort().sort(integers, 0, integers.length);
            for (int i : integers) {
                System.out.print(i + " ");
            }
            System.out.println("----------------------");
        }
    }
}
