package netease;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by fdh on 2017/8/14.
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Deque<Integer> deque = new ArrayDeque<>(n);
        Boolean left = (n % 2 != 0);
        for(int i = 0; i < n;i++) {
            Integer integer = scanner.nextInt();
            if(left) {
                deque.addFirst(integer);
            } else {
                deque.addLast(integer);
            }
            left = !left;
        }
        StringBuilder stringBuilder = new StringBuilder(n);
        for (Integer integer : deque) {
            stringBuilder.append(integer + " ");
        }

        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }

}
