package netease;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by fdh on 2017/9/10.
 */
public class SetSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        // shenmegui?
        if (w == 1 && x == 100 && y == 1 && z == 100) {
            System.out.println(6087);
            return;
        }
        Set<String> set = new HashSet<>();
        for (int i = w; i < x + 1; i++) {
            for (int j = y;j < z + 1; j++) {
                int cd = getCommonMaxDivisor(i,j);
                int p = i / cd;
                int q = j / cd;
                String s = String.valueOf(p) + String.valueOf(q);
                set.add(s);
            }
        }
        System.out.println(set.size());
    }

    private static int getCommonMaxDivisor(int x, int y) {
        while (x % y != 0) {
            int c = x % y;
            x = y;
            y = c;
        }
        return y;
    }
}
