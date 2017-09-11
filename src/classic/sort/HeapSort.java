package classic.sort;

import java.util.List;

/**
 * Created by fdh on 2017/9/10.
 */
public class HeapSort {
    public static void adjustMinHeapUp(int[] heap, int i) {
        int pi = (i - 1) >> 1;
        int temp = heap[i];
        while (i > 0) {
            if (heap[pi] <= temp) {
                break;
            }
            heap[i] = heap[pi];

            i = pi;
            pi = (i - 1) >> 1;
        }
        heap[i] = temp;
    }

    public static void adjustMinHeapDown(int[] heap, int i) {
        int n = heap.length;
        int temp = heap[i];
        int child = 2 * i + 1;
        while (child < n) {
            if (child + 1 < n && heap[child + 1] < heap[child]) {
                child++;
            }
            if (temp <= heap[child]) {
                break;
            }

            heap[i] = heap[child];

            i = child;
            child = 2 * i + 1;
        }

        heap[i] = temp;
    }

    public static void makeMinHeap(int[] ints) {
        int n = ints.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            adjustMinHeapDown(ints,i);
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{60,50,2,70,5,5,4,6,9};
        makeMinHeap(ints);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
