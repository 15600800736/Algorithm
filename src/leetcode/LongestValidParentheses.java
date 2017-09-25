package leetcode;

import java.util.Stack;

/**
 * Created by fdh on 2017/9/24.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        if (s.length() == 2) {
            if (s.equals("()")) {
                return 2;
            } else {
                return 0;
            }
        }
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        stack.push(s.charAt(0));
        dp[1] = s.substring(0,2).equals("()") ? 2 : 0;
        stack.push(s.charAt(1));
        if (dp[1] > max) {
            max = dp[1];
        }
        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dp[i] = 0;
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    dp[i] = 0;
                    stack.push(s.charAt(i));
                } else {
                    char ch = stack.peek();
                    if (ch == '(') {
                        dp[i] = dp[i - 2] + 2;
                        stack.pop();
                    } else {
                        if (s.charAt(i - 1 - (dp[i - 1])) == '(') {

                        }
                        stack.push(s.charAt(i));
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "()(())";

        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }
}
