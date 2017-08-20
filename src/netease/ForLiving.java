package netease;

import java.util.Scanner;

/**
 * Created by fdh on 2017/8/14.
 */
public class ForLiving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer x = scanner.nextInt();
        Integer f = scanner.nextInt();
        Integer d = scanner.nextInt();
        Integer p = scanner.nextInt();

        if(d < x * f) {
            System.out.println(d/x);
            return;
        }
        Integer r = d - f * x;
        Integer delta = r / (x + p);
        System.out.println(f + delta);
    }
}
