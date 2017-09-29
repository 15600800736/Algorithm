package leetcode;

/**
 * Created by fdh on 2017/9/27.
 */
public class MedianOfTwoSortedNumber {
    public int findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] minNum = nums1.length <= nums2.length ? nums1 : nums2;
        int[] maxNum = nums1.length > nums2.length ? nums1 : nums2;

        int m = nums1.length <= nums2.length ? nums1.length : nums2.length;
        int n = nums1.length > nums2.length ? nums1.length : nums2.length;

        int low = 0, high = m - 1;
        while (low < high) {
            int i = (low + high) >> 1;
            int j = ((m + n + 1) >> 1) - i;
            if (minNum[i - 1] <= maxNum[j] && maxNum[j - 1] <= minNum[i]) {
                if (m + n % 2 == 0) {
                    return (Math.max(minNum[i - 1], maxNum[j - 1]) + Math.min(minNum[i], minNum[j])) >> 1;
                }
                if (m + n % 2 == 1) {
                    return Math.max(minNum[i - 1], maxNum[j - 1]);
                }
            }
            if (minNum[i - 1] > maxNum[j]) {
                high = i;
            } else if (maxNum[j - 1] > minNum[i]) {
                low = i + 1;
            }
        }
        return 0;
    }
}
