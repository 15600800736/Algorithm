package netease;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fdh on 2017/9/11.
 */
public class MagicCoin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            if (n % 2 == 0) {
                stack.push(2);
                n = (n - 2) / 2;
            } else {
                stack.push(1);
                n = (n - 1) / 2;
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
