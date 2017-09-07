package toutiao;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/7.
 */
public class Widest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        Integer coor = null;
        int[] re = new int[]{-1,-1};
        boolean reachHighest = false;
        for (int i = 0; i < n - 1; i++) {
            if (!reachHighest) {
                if (ints[i + 1] > ints[i] && coor == null) {
                    coor = i;
                    continue;
                }
                if (ints[i + 1] < ints[i]) {
                    reachHighest = true;
                }
            } else {
                if (ints[i + 1] > ints[i]) {
                    if (i - coor > re[1] - re[0]) {
                        re[0] = coor;
                        re[1] = i;
                    }
                    reachHighest = false;
                    i--;
                    coor = null;
                }
            }
        }
        if (reachHighest && ints[n - 1] < ints[n - 2] && n - 1 - coor > re[1] - re[0]) {
            re[0] = coor;
            re[1] = n - 1;
        }
        System.out.println(re[0] + " " + re[1]);
    }
}
