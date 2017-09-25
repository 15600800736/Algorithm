package leetcode;

import java.util.*;

/**
 * Created by fdh on 2017/9/25.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new LinkedList<>();
        }

        if (candidates.length == 1) {
            if (target % candidates[0] == 0) {
                List<Integer> l = new LinkedList<>();
                for (int i = 0; i < (target / candidates[0]); i++) {
                    l.add(candidates[0]);
                }
                List<List<Integer>> result = new LinkedList<>();
                result.add(l);
                return result;
            } else {
                return new LinkedList<>();
            }

        }
        List<List<List<Integer>>> lists = new ArrayList<>(target + 1);
        merge(candidates, 0, candidates.length);
        int index = binaryFind(candidates, 0, candidates.length, target);

        for (int i = 0; i < target + 1; i++) {
            lists.add(new LinkedList<>());
        }
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < index + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                List<List<Integer>> list = lists.get(j);
                if (j >= candidates[i]) {
                    int temp = candidates[i];
                    int m = 1;
                    while (j >= temp) {
                        List<List<Integer>> ol = lists.get(j - temp);
                        if (ol.size() == 0) {
                            if (temp == j) {
                                List<Integer> l = new LinkedList<>();
                                for (int o = 0; o < m; o++) {
                                    l.add(candidates[i]);
                                }
                                if (j == target) {
                                    if (!set.contains(l)) {
                                        list.add(l);
                                        set.add(l);
                                    }
                                } else {
                                    list.add(l);
                                }
                            }
                        } else {
                            for (List<Integer> integers : ol) {
                                List<Integer> l = new LinkedList<>(integers);
                                for (int o = 0; o < m; o++) {
                                    l.add(candidates[i]);
                                }
                                if (j == target) {
                                    if (!set.contains(l)) {
                                        list.add(l);
                                        set.add(l);
                                    }
                                } else {
                                    list.add(l);
                                }
                            }
                        }
                        m++;
                        temp *= m;
                    }
                }
            }
        }



        return lists.get(target);
    }

    private void merge(int[] nums, int low, int high) {
        if (high - low < 2) {
            return;
        }
        int mid = (low + high) >> 1;
        merge(nums, low, mid);
        merge(nums, mid, high);

        int[] temp = Arrays.copyOfRange(nums, low, mid);
        int i = 0, j = mid, k = low;
        while (k < high) {
            if (i >= mid - low || (i < mid - low && j < high && temp[i] >= nums[j])) {
                nums[k++] = nums[j++];
                continue;
            }
            if (j >= high || (i < mid - low && j < high && temp[i] < nums[j])) {
                nums[k++] = temp[i++];
            }
        }
    }

    private int binaryFind(int[] nums, int low, int high, int target) {
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
        }

        if (low == nums.length) {
            return low - 1;
        }
        if (nums[low] > target) {
            if (low == 0) {
                return -1;
            } else {
                return low - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,7};
        System.out.println(new CombinationSum().combinationSum(nums,12));
    }

}
