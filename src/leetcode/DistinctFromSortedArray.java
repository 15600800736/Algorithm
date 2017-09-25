package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fdh on 2017/9/24.
 */
public class DistinctFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
