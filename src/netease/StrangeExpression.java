package netease;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/10.
 */
public class StrangeExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char c = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while (c >= '0' && c <= '9') {
            sb.append(c);
            c = s.charAt(++j);
        }
        int res = Integer.parseInt(sb.toString());
        while (j < s.length()) {
            char op = s.charAt(j);
            sb = new StringBuilder();
            c = s.charAt(++j);
            while (j < s.length() && c >= '0' && c <= '9') {
                sb.append(c);
                ++j;
                if (j < s.length()) {
                    c = s.charAt(j);
                }
            }

            if (op == '+') {
                res += Integer.parseInt(sb.toString());
                continue;
            }
            if (op == '-') {
                res -= Integer.parseInt(sb.toString());
                continue;
            }
            if (op == '*') {
                res *= Integer.parseInt(sb.toString());
            }
        }

        System.out.println(res);
    }
}
