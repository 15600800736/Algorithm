package leetcode;

/**
 * Created by fdh on 2017/9/26.
 */
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] way = new int[nums.length];
        int lis = 1;
        way[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            lis = Math.max(lis, dp[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] == dp[i] - 1) {
                    way[i] += way[j];
                }
            }
            if (way[i] == 0) {
                way[i] = 1;
            }
        }
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == lis) {
                num += way[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(nums));
    }
}
