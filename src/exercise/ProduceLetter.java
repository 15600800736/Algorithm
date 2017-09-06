package exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by fdh on 2017/9/6.
 */
public class ProduceLetter {
    public static void main(String[] args) {
//        Random random = new Random();
//        Set<Character> s = new HashSet<>(20);
//        while (s.size() < 20) {
//            int r = random.nextInt((int)'z') % ((int)'z' - (int)'a' + 1) + (int)'a';
//            s.add((char)r);
//        }
//        Character[] chars;
//        chars = s.toArray(new Character[0]);
//        mergeSort(chars, 0, 20);
//        for (Character aChar : chars) {
//            System.out.println(aChar);
//        }
        System.out.println("3" + 2);
    }

    private static void mergeSort(Character[] chars, int low, int high) {
        if (high - low < 2) {
            return;
        }

        int mid = (high + low) >> 1;
        mergeSort(chars, low, mid);
        mergeSort(chars, mid, high);

        Character[] temp = Arrays.copyOfRange(chars,low,high);
        for (int i = low, j = 0, k = mid; i < high; i++) {
            if (j >= mid - low || (j < mid - low && k < high && temp[j] <= chars[k])) {
                chars[i] = chars[k++];
                continue;
            }

            if (k >= high || (j < mid - low && k < high && chars[k] < temp[j])) {
                chars[i] = temp[j++];
            }
        }
    }

}
