package soho;

import java.util.*;

/**
 * Created by fdh on 2017/8/17.
 */
public class PageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer[][] integers = new Integer[10][2];

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 2; j++) {
                integers[i][j] = 0;
            }
        }

        integers[1][0] = 1;
        int temp;
        for (int i = 2; i < n + 1; i++) {
            for(int j = 0; j < 10; j++) {
                integers[j][1] = integers[j][0];
            }
            temp = i;
            while(temp != 0) {
                int k = temp - temp/10 * 10;
                integers[k][1] = integers[k][1] + 1;
                temp = temp/10;
            }
            for(int j = 0; j < 10; j++) {
                integers[j][0] = integers[j][1];
                integers[j][1] = 0;
            }

        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            result.append(String.valueOf(integers[i][0])).append(" ");
        }
        System.out.println(result.substring(0, result.length() - 1));
    }
}
