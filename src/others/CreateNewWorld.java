
import java.util.Scanner;

/**
 * Created by fdh on 2017/8/20.
 */
public class CreateNewWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            Integer x = scanner.nextInt();
            Integer n = scanner.nextInt();
            Integer m = scanner.nextInt();

            Integer[] zero = new Integer[x];
            Integer[] one = new Integer[x];

            String s;
            int[][] num = new int[n + 1][m + 1];
            for (Integer i = 0; i < x; i++) {
                zero[i] = 0;
                one[i] = 0;
                s = scanner.next();
                for (int j = 0; j < s.length(); j++) {
                    Character ch = s.charAt(j);
                    if (ch == '0') {
                        zero[i]++;
                    } else {
                        one[i]++;
                    }
                }
            }



            for (Integer i = 0; i < x; i++) {
                for (Integer j = n; j >= zero[i]; j--) {
                    for (Integer k = m; k >= one[i]; k--) {
                        if (num[j][k] < num[j - zero[i]][k - one[i]] + 1) {
                            num[j][k] = num[j - zero[i]][k - one[i]] + 1;
                        }
                    }
                }
            }

            System.out.println(num[n][m]);
        }
    }
}
