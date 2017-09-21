package oj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by fdh on 2017/9/21.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> set = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }

        if (n == 0) {
            System.out.println(1);
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }

    }
}
