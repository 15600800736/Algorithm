package leetcode;

import java.util.*;

/**
 * Created by fdh on 2017/9/23.
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> lists = new LinkedList<>();
        if (nums.length < 3) {
            return lists;
        }
        Set<List<Integer>> set = new HashSet<>();
        merge(nums, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int l = i + 1; l < nums.length; l++) {
                int j = l + 1, k = nums.length - 1;
                int t = target - nums[i] - nums[l];
                while (j < k) {
                    if (nums[j] + nums[k] > t) {
                        k--;
                    } else if (nums[j] + nums[k] < t) {
                        j++;
                    } else {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[l]);
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
        int[] ints = new int[]{1,0,-1,0,-2,2};
        fourSum(ints,0).forEach(l -> {
            l.forEach(System.out::print);
            System.out.println();
        });
    }
}
