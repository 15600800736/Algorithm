package classic.find;

/**
 * Created by fdh on 2017/9/23.
 */
public class BinaryFind {
    public static int binaryFind(int[] nums, int low, int high, int target) {
        while(low < high) {
            int mid = (low + high) >> 1;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,10,23,56};
        System.out.println(binaryFind(nums,0,nums.length,11));
    }
}
