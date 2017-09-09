package netease;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class GoToWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carNum = scanner.nextInt();
        int[] x = new int[carNum];
        int[] y = new int[carNum];

        for (int i = 0; i < carNum; i++) {
            x[i] = scanner.nextInt();
        }

        for (int i = 0; i < carNum; i++) {
            y[i] = scanner.nextInt();
        }

        int gx = scanner.nextInt();
        int gy = scanner.nextInt();

        int walkTime = scanner.nextInt();
        int taxiTime = scanner.nextInt();

        int min = (Math.abs(gx) + Math.abs(gy)) * walkTime;

        for (int i = 0; i < carNum; i++) {
            int res = (Math.abs(x[i]) + Math.abs(y[i])) * walkTime + (Math.abs(gx - x[i]) + Math.abs(gy - y[i])) * taxiTime;
            if (res < min) {
                min = res;
            }
        }
        System.out.println(min);
    }
}
