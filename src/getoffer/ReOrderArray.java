package getoffer;

/**
 * Created by fdh on 2017/8/24.
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        if (array.length == 1) {
            return;
        }
        Integer[] odd = new Integer[array.length];
        Integer[] even = new Integer[array.length];
        for (int i = 0, j = 0, k = 0; i < array.length; i++) {
            if ((array[i] & 1) != 0) {
                odd[j++] = array[i];
            } else {
                even[k++] = array[i];
            }
        }

        int i = 0;
        while (odd[i] != null) {
            array[i] = odd[i++];
        }
        int j = 0;
        while (even[j] != null) {
            array[i++] = even[j++];
        }
    }
}
