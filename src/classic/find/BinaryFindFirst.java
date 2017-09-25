package classic.find;

/**
 * Created by fdh on 2017/9/23.
 */
public class BinaryFindFirst {
    public static int binaryFindFirst(int[] nums, int low, int high, int target) {
        while(low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                if (mid - 1 > 0 && nums[mid - 1] == target) {
                    high = mid;
                } else {
                    return mid;
                }
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,3,4,5,6};
        System.out.println(binaryFindFirst(nums,0,nums.length,1));
    }
}
