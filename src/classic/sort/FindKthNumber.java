package classic.sort;

import java.util.Random;

/**
 * Created by fdh on 2017/9/26.
 */
public class FindKthNumber {
    public Integer findKthNumber(int[] nums, int k) {
        if (k > nums.length) {
            return null;
        }
        int low = 0, high = nums.length;
        while (low < high) {
            int r = rand(low, high);
            int i = low, j = high - 1;
            swap(nums, r, low);
            int temp = nums[low];
            while (i < j) {
                while (i < j && nums[j] >= temp) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && nums[j] < temp) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = temp;
            if (i == k - 1) {
                return nums[i];
            } else if (i < k - 1) {
                low = i + 1;
            } else {
                high = i;
            }
        }

        return 0;
    }


    private int rand(int low, int high) {
        if (high - low == 1) {
            return low;
        }
        return new Random().nextInt(high - 1) % (high - low) + low;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 3, 4, 6, 7, 8, 9};
        for (int i = 0; i < (10); i++) {
            System.out.println(new FindKthNumber().findKthNumber(nums, 4));
        }
    }
}

