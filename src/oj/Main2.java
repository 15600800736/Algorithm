package oj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by fdh on 2017/9/21.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Set<Character> set = new HashSet<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                System.out.print(s.charAt(i));
            }
        }
    }
}
