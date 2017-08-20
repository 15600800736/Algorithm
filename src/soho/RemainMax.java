package soho;

import java.util.*;

/**
 * Created by fdh on 2017/8/16.
 */
public class RemainMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer count = scanner.nextInt();
        String s = String.valueOf(n);
        Integer[] ns = new Integer[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ns[i] = Character.getNumericValue(s.charAt(i));
        }
        sort(ns, 0, ns.length);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < count; i++) {
            stack.push(ns[i]);
        }

        while(!stack.empty()) {
            Integer integer = stack.pop();
            for(int i = 0; i < s.length(); i++) {
                if(Character.getNumericValue(s.charAt(i)) == integer) {
                    s = s.substring(0, i) + s.substring(i + 1);
                    break;
                }
            }
        }

        System.out.println(s);
    }
    private static void sort(Integer[] list, int low, int high) {

        if (high - low < 2) {
            return;
        }
        int mid = (low + high) / 2;
        sort(list, low, mid);
        sort(list, mid, high);
        Integer[] lowToMid = Arrays.copyOfRange(list, low, mid);
        int j = 0;
        int k = mid;
        for(int i = low; i < high; i++) {
            if(j >= mid - low || (j < mid - low && k < high && lowToMid[j] > list[k])) {
                list[i] = list[k];
                k++;
                continue;
            }
            if(k >= high || (k < high && j < mid - low && list[k] >= lowToMid[j])) {
                list[i] = lowToMid[j];
                j++;
            }
        }
    }
}
