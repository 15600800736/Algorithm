package soho;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by fdh on 2017/8/17.
 */
public class ATCG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        if(s1.length() != s2.length()) {
            return;
        }
        int time = 0;
        Map<Character, Character> map = new HashMap<>(4);

        map.put('A', 'T');
        map.put('T', 'A');
        map.put('C', 'G');
        map.put('G', 'C');
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            if(c2[i] != map.get(c1[i])) {
                time++;
            }
        }
        System.out.println(time);
    }
}
