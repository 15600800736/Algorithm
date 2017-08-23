package getoffer;

/**
 * Created by fdh on 2017/8/23.
 */
public class CountOfBinaryOne {
    public int NumberOf1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == Integer.MIN_VALUE) {
            return 16;
        }
        if (n < 0) {
            n = -n;
        }
        int one = 0;
        while (n == 1) {
            int temp = n;
            n >>= 1;
            if (temp - (n << 2) == 1) {
                one++;
            }
        }
        return 0;
    }
}
