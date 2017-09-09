package netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fdh on 2017/9/10.
 */
public class AdjustQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        List<Integer> G = new ArrayList<>(s.length() / 2);
        List<Integer> B = new ArrayList<>(s.length() / 2);
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == 'G') {
                G.add(j);
            } else {
                B.add(j);
            }
        }
        int min1 = move(s, G, true);
        int min2 = move(s, G, false);
        int min3 = move(s, B, true);
        int min4 = move(s, B, false);
        System.out.println(min(min1,min2,min3,min4));
    }

    private static int move(String s, List<Integer> list, boolean left) {
        int min = 0;
        if (left) {
            for (int k = 0; k < list.size(); k++) {
                min += (list.get(k) - k);
            }
        } else {
            for (int k = 0; k < list.size(); k++) {
                min += (s.length() - (list.size() - k) - list.get(k));
            }
        }
        return min;
    }

    private static int min(Integer... integers) {
        return getMin(integers,0,integers.length);
    }

    private static int getMin(Integer[] integers, int low, int high) {
        if (high - low < 2) {
            return integers[low];
        }
        if (high - low < 3) {
            return Math.min(integers[low], integers[low + 1]);
        }

        int mid = (high + low) >> 1;
        return Math.min(getMin(integers, low, mid),getMin(integers, mid, high));
    }
}
