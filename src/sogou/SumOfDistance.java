package sogou;

import java.util.Scanner;

/**
 * Created by fdh on 2017/9/14.
 */
public class SumOfDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        int[] nums = new int[(ints[n - 1] - ints[0]) / 2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = isPrime(ints[0] + 2 * i + 1) ?
                    (i - 1 > -1 ? nums[i - 1] + 1 : 1) :
                    (i - 1 > -1 ? nums[i - 1] : 0);
        }

        int sum = 0;
        Integer lastIndex = null;
        for (int i = 1; i < ints.length; i++) {
            int even = ints[i];

            int index = (even - ints[0]) / 2 - 1;
            if (index == 0) {
                sum += (i * (ints.length - i) * nums[index]);
            } else {
                sum += (i * (ints.length - i) * (nums[index] - (lastIndex == null ? 0 :nums[lastIndex])));
            }
            lastIndex = index;
        }

        System.out.println(sum);

    }

    public static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 6 != 5 && n % 6 != 1) {
            return false;
        }

        for (int i = 5; i < Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
