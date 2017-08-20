package netease;

import java.util.Scanner;

/**
 * Created by fdh on 2017/8/14.
 */
public class DiffSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int length = s.length();
        if(length == 1) {
            System.out.println(1);
            return;
        }
        Integer[] maxNum = new Integer[length];
        maxNum[0] = 1;
        int max = maxNum[0];
        for(int i = 1; i < length; i++) {
            maxNum[i] = s.charAt(i) == s.charAt(i - 1) ? 1 : maxNum[i - 1] + 1;
            if(maxNum[i] > max) {
                max = maxNum[i];
            }
        }

        System.out.println(max);
    }
}
