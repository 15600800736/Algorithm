package wangyiyoudao;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class ConstructingQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        Deque<Integer> queue = new LinkedList<>();
        int[] ints = new int[t];
        for (int i = 0; i < t; i++) {
            ints[i] = scanner.nextInt();
        }

        for (int i = 0; i < t; i++) {
            int n = ints[i];
            for (int j = n; j > 0; j--) {
                queue.addFirst(j);
                int l = queue.pollLast();
                queue.addFirst(l);
            }
            for (int j = 0; j < n; j++) {
                int k = queue.pollFirst();
                System.out.print(k);
                if (j == n - 1) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
            queue.clear();
        }
    }
}
