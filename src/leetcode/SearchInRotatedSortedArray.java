package leetcode;

/**
 * Created by fdh on 2017/9/24.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // find the min element's index in the array
        int minIndex = 0;
        int low = 0, high = nums.length;
        if (nums[low] > nums[high - 1]) {
            while (low < high) {
                int mid = (low + high) >> 1;
                if (mid == 0) {
                    minIndex = nums[0] < nums[1] ? 0 : 1;
                }
                if (mid == nums.length - 1) {
                    minIndex = nums[nums.length - 1] < nums[nums.length - 2] ? nums.length - 1 : nums.length - 2;
                }
                if (nums[mid] >= nums[0]) {
                    low = mid + 1;
                } else if (nums[mid] <= nums[nums.length - 1]) {
                    high = mid;
                }

            }
        }

        // binary search


        return -1;
    }

    public int proxyIndex(int index,int delta,int l) {
        return (index + delta) % l;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(new SearchInRotatedSortedArray().search(nums, 0));
    }
}
