package netease;

import java.util.*;

/**
 * Created by fdh on 2017/9/10.
 */
public class Distinct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        Map<Integer, Integer> im = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            im.put(ints[i], i);
        }
        Set<Integer> set = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            set.add(ints[i]);
        }

        Integer[] newInts = new Integer[n];
        for (Integer i : set) {
            newInts[im.get(i)] = i;
        }

        for (int i = 0; i < newInts.length; i++) {
            if (newInts[i] != null) {
                System.out.print(newInts[i]);
                if (i != n - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
