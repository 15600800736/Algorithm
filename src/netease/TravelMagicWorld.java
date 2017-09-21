package netease;

import java.util.*;

/**
 * Created by fdh on 2017/9/16.
 */
public class TravelMagicWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int L = scanner.nextInt();

        int[] parent = new int[n - 1];

        for (int i = 0; i < (n - 1); i++) {
            parent[i] = scanner.nextInt();
        }

        Stack<Iterator<Integer>> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>(2 * n);
        for (int i = 0; i < (n - 1); i++) {
            List<Integer> list1 = map.get(i + 1);
            if (list1 != null) {
                list1.add(parent[i]);
            } else {
                list1 = new LinkedList<>();
                list1.add(parent[i]);
                map.put(i +1, list1);
            }

            List<Integer> list2 = map.get(parent[i]);
            if (list2 != null) {
                list2.add(i + 1);
            } else {
                list2 = new LinkedList<>();
                list2.add(i + 1);
                map.put(parent[i], list2);
            }

        }
        int l = 0;
        List<Integer> list = map.get(l);
        if (list == null) {
            System.out.println(1);
            return;
        }

        Iterator<Integer> itr = list.iterator();
        set.add(l);
        stack.push(itr);
        for (int i = 0; i < L; i++) {
            
        }

    }
}
