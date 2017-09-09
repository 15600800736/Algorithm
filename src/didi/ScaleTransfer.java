package didi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fdh on 2017/9/9.
 */
public class ScaleTransfer {
    public static void main(String[] args) {
        String[] str = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer s = scanner.nextInt();

        if (n < 0) {
            System.out.print("-");
            n = -n;
        }
        Stack<Integer> q = new Stack<>();
        while (n != 0) {
            q.add(n - n / s * s);
            n /= s;
        }
        while (!q.isEmpty()) {
            System.out.print(str[q.pop()]);
        }
    }
}
