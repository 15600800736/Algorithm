package baidu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by fdh on 2017/9/14.
 */
public class FindSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();

        int j = 0;

        Set<String> set = new HashSet<>();
        set.add(s.substring(0,1));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(j)) {
                String sub = s.substring(j, i + 1);
                set.add(sub);
            } else {
                j = i;
                set.add(s.substring(j,j+1));
            }
        }
        System.out.println(set.size());
    }
}
