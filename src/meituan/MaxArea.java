package meituan;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fdh on 2017/8/15.
 */
public class MaxArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer[] height = new Integer[n];
        for(int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        Stack<Integer> s = new Stack<>();
        int max_area = 0; // 最大矩形面积
        int tp; // 栈顶
        int area_with_top;

        int i = 0;
        while (i < n) {
            if (s.empty() || height[s.peek()] <= height[i]) {
                s.push(i++);
            } else {
                tp = s.pop();
                area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
                max_area = Math.max(max_area, area_with_top);
            }
        }

        while (!s.empty()) {
            tp = s.pop();
            area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
            max_area = Math.max(max_area, area_with_top);
        }
        System.out.println(max_area);
    }
}
