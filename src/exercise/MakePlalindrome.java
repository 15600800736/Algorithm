package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by fdh on 2017/9/2.
 */
public class MakePlalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (s == null || s.length() == 0) {
            System.out.println(0);
        }

        Map<Character,Integer> map = new HashMap<>(1000);


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer n = map.get(c);
            if (n == null) {
                map.put(c, 1);
            } else {
                map.put(c, n + 1);
            }
        }

        int num = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer v = entry.getValue();
            if ((v & 1) == 1) {
                num++;
            }
        }

        System.out.println(num);

    }
}
