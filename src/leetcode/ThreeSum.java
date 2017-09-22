package leetcode;

import java.util.*;

/**
 * Created by fdh on 2017/9/22.
 */

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums.length < 3) {
            return lists;
        }
        merge(nums, 0, nums.length);

        boolean allZero = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) {
            List<Integer> list = new ArrayList<>(3);
            for (int i = 0; i < 3; i++) {
                list.add(0);
            }
            lists.add(list);
            return lists;
        }
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];

            while (j < k) {
                if (nums[j] + nums[k] > target) {
                    k--;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    if (!set.contains(list)) {
                        lists.add(list);
                        set.add(list);
                    }
                    j++;
                }
            }
        }
        return lists;
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
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
    }

}
