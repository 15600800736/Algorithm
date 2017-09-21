package sogou;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fdh on 2017/9/14.
 */
public class LongestPalindromePrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(0)) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int i = 0;
            int j = stack.pop();
            int tmp = j;
            boolean flag = true;
            while (!(j < i)) {
                if (s.charAt(i) != s.charAt(j)) {
                    flag = false;
                    break;
                }
                i++;
                j--;
            }
            if (flag) {
                System.out.println(tmp + 1);
                return;
            }
        }
        System.out.println(1);
    }
}
