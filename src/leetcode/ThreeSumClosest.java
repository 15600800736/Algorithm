package leetcode;

import java.util.Arrays;

/**
 * Created by fdh on 2017/9/22.
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        merge(nums, 0, nums.length);
        int minDiff = nums[0] + nums[1] + nums[2] - target;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            int originalDiff = nums[i] + nums[k] + nums[j] - target;
            if (originalDiff == 0) {
                return target;
            }
            while (j < k) {
                int diff = nums[i] + nums[k] + nums[j] - target;
                if (diff == 0) {
                    return target + diff;
                }
                if(Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                }
                if (diff > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return target + minDiff;
    }

    public static void merge(int[] integers, int low, int high) {
        if (high - low < 2) {
            return;
        }
        int mid = (high + low) >> 1;
        merge(integers, low, mid);
        merge(integers, mid, high);

        int[] temp = Arrays.copyOfRange(integers, low, mid);
        for (int i = low, j = 0, k = mid; i < high; i++) {
            if (j >= mid - low || (j < mid - low && k < high && integers[k] < temp[j])) {
                integers[i] = integers[k++];
                continue;
            }
            if (k >= high || (j < mid - low && k < high && integers[k] >= temp[j])) {
                integers[i] = temp[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,4,8,16,32,64,128};
        threeSumClosest(ints,82);
    }
}
