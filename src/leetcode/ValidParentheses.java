package leetcode;

import java.util.Stack;

/**
 * Created by fdh on 2017/9/23.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ||
                    s.charAt(i) == '[' ||
                    s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (c != '(') {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (c != '[') {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (c != '{') {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
