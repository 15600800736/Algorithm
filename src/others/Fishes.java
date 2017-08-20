package others;

import java.util.Scanner;

/**
 * Created by fdh on 2017/8/17.
 */
public class Fishes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer minSize = scanner.nextInt();
        Integer maxSize = scanner.nextInt();
        Integer n = scanner.nextInt();
        Integer[] sizes = new Integer[n];
        for (Integer i = 0; i < n; i++) {
            sizes[i] = scanner.nextInt();
        }
        Integer kind = 0;
        for (int i = minSize; i < maxSize + 1; i++) {
            Boolean flag = true;
            for (int j = 0; j < n; j++) {
                if ((i >= 2 * sizes[j] && i <= 10 * sizes[j]) || (sizes[j] >= 2 * i && sizes[j] <= 10 * i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                kind++;
            }
        }
        System.out.println(kind);
    }
}
