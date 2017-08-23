package getoffer;

/**
 * Created by fdh on 2017/8/23.
 */
public class Jump {
    public int JumpFloor(int target) {
        if(target == 0) {
            return 1;
        }
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }

        int[] num = new int[target + 1];
        num[0] = 1;
        num[1] = 1;
        num[2] = 2;

        for (int i = 3; i < target + 1; i++) {
            for(int j = i - 1; j > 0;j--) {
                num[i] += num[j];
            }
            num[i]++;
        }

        return num[target];
    }
}
