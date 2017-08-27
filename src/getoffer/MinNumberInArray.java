package getoffer;

/**
 * Created by fdh on 2017/8/26.
 */
public class MinNumberInArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int i = 0;
        int j = array.length - 1;

        boolean flag = false;
        for (int k = 0; k < array.length - 1; k++) {
            if (array[k] > array[k + 1]) {
                flag = true;
            }
        }
        if (!flag) {
            return array[0];
        }
        while (j - i > 1) {
            int mid = (i + j) >> 1;
            if (array[mid] > array[i]) {
                i = mid;
            }
            if (array[mid] < array[j]) {
                j = mid;
            }
        }

        return array[j];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,0,1,1,1};
        System.out.println(new MinNumberInArray().minNumberInRotateArray(array));
    }
}
