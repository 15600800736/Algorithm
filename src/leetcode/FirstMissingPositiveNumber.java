package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fdh on 2017/9/26.
 */
public class FirstMissingPositiveNumber {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i < nums.length + 2; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
