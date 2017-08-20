package netease;

import java.util.Scanner;

/**
 * Created by fdh on 2017/8/13.
 */
public class ColorfulSquare {
    public static void main(String... strings) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (s == null) {
            System.out.println(0);
            return;
        }
        Integer length = s.length();
        if(length == 0) {
            System.out.println(0);
            return;
        }
        Character first = s.charAt(0);
        Character second = null;
        for (Integer i = 1; i < length; i++) {
            if (second != null) {
                if(s.charAt(i) != second && s.charAt(i) != first) {
                    System.out.println(0);
                    return;
                }
            } else {
                if (i == length - 1) {
                    System.out.println(1);
                    return;
                }
                if (s.charAt(i) != first) {
                    second = s.charAt(i);
                }
            }
        }
        System.out.println(2);
    }
}
