package toutiao;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/7.
 */
public class Trie {
    private static long num = 0L;
    private static long res = 0L;
    private static int depth = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            int depth = 0;
            long temp = n;
            while (temp != 0) {
                temp /= 10;
                depth++;
            }
            Trie.depth = depth;
            char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
            for (int i = 1; i < 10; i++) {
                boolean flag = lookBack(m,n,new StringBuilder(),digits[i],1, digits);
                if (flag) {
                    System.out.println(res);
                    return;
                }
            }
        }
    }

    private static boolean lookBack(long m, long n, StringBuilder str, char ap,final int depth, char[] digits) {
        StringBuilder strap = str.append(ap);
        if (Long.parseLong(strap.toString()) > n) {
            strap.deleteCharAt(strap.length() - 1);
            return true;
        }
        num++;
        if (num == m) {
            res = Long.parseLong(strap.toString());
            return true;
        }
        if (depth == Trie.depth) {
            strap.deleteCharAt(strap.length() - 1);
            return false;
        }
        for (char digit : digits) {
            boolean flag = lookBack(m,n,strap,digit,depth + 1, digits);
            if (flag) {
                if (res != 0) {
                    return true;
                } else {
                    strap.deleteCharAt(strap.length() - 1);
                    return false;
                }
            }
        }
        strap.deleteCharAt(strap.length() - 1);
        return false;
    }
}
