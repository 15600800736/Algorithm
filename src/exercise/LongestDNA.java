package exercise;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/1.
 */
public class LongestDNA {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();

        if (s == null || s.length() == 0) {
            System.out.println(0);
        }

        int max = 0;
        int[] l = new int[2];

        l[0] = isDNA(s.charAt(0)) ? 1 : 0;

        for (int i = 1; i < s.length(); i++) {
            l[1] = isDNA(s.charAt(i)) ? l[0] + 1 : 0;
            max = l[1] > max ? l[1] : max;
            l[0] = l[1];
        }
        System.out.println(max);

    }

    private static boolean isDNA(char c) {
        return c == 'A' || c == 'T' || c == 'C' || c == 'G';
    }
}
