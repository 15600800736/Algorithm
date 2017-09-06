package exercise;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/1.
 */
public class ColorfulSquare {

    public static void main(String...strings) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        int i = 0;
        int r = 0;
        while (i < s.length()) {
            if (i == s.length() - 1) {
                break;
            }
            if (i + 1 < s.length()) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    r++;
                    i += 2;
                } else {
                    i++;
                }
            } else {
                break;
            }
        }
        System.out.println(r);
    }
}
