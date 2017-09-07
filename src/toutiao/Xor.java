package toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fdh on 2017/9/7.
 */
public class Xor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        int max = 1;
        while (m > max) {
            max <<= 1;
        }
        List<Integer> i1 = new ArrayList<>(n/2);
        List<Integer> i2 = new ArrayList<>(n - n/2);
        for (int i = 0; i < n; i++) {
            if (ints[i] < max) {
                i1.add(ints[i]);
            } else {
                i2.add(ints[i]);
            }
        }
        int num = i2.size() * i1.size();
        for (int i = 0; i < i1.size(); i++) {
            for (int j = i + 1; j < i1.size(); j++) {
                int result = i1.get(i) ^ i1.get(j);
                if (result > m) {
                    num++;
                }
            }
        }
        for (int i = 0; i < i2.size(); i++) {
            for (int j = i + 1; j < i2.size(); j++) {
                int result = i2.get(i) ^ i2.get(j);
                if (result > m) {
                    num++;
                }
            }
        }

        System.out.println(num);

    }

    
}
