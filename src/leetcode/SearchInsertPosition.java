package leetcode;

/**
 * Created by fdh on 2017/9/26.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0) {
            return 0;
        }
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low == nums.length) {
            return low;
        } else if (nums[low] > target) {
            return low;
        } else {
            return low + 1;
        }
    }

    public static void main(String[] args) {

    }
}
