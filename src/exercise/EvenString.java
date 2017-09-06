package exercise;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fdh on 2017/9/2.
 */
public class EvenString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (s.length() == 0) {
            return;
        }

        char f = s.charAt(0);
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < s.length() / 2; i++) {
            if (s.charAt(i) == f) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            boolean flag = true;
            int i = stack.pop();
            for (int j = i, k = 0; j < (i << 1) && k < i; j++, k++) {
                if (s.charAt(k) != s.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(2 * i);
            }
        }
    }
}
