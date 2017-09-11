package netease;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by fdh on 2017/9/11.
 */
public class PieceOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (s.length() == 0) {
            System.out.println(0);
        }
        char target = s.charAt(0);
        int num = 1;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) != target) {
                num++;
                target = s.charAt(i);
            }
            i++;
        }
        int l = s.length();
        float res = (float)l / num;
        System.out.println(new DecimalFormat("#.00").format(res));
    }
}
