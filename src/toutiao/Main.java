package toutiao;

import java.util.*;

/**
 * Created by fdh on 2017/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        int m = scanner.nextInt();

        int max = 0;
        Map<Character, List<Integer>> map = new HashMap<>(40);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> list = map.get(c);
            if (list == null) {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(c,newList);
            } else {
                list.add(i);
            }
        }

        for (List<Integer> list : map.values()) {
            int longest = 1;
            int left = 0;
            int right = 0;
            Iterator<Integer> itr = list.iterator();
            int num = 1;
            int last = itr.next();
            int j = 0;
            int i = 0;
            while (itr.hasNext()) {
                j++;
                Integer integer = itr.next();
                if (integer == last + 1) {
                    num++;
                } else {
                    num = 1;
                    i = j;
                }
                if (num > longest) {
                    longest = num;
                    left = i;
                    right = j;
                }
                last = integer;
            }

        }
    }
}
