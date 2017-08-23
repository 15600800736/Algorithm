package getoffer;

/**
 * Created by fdh on 2017/8/23.
 */
public class CoverRect {
    public int RectCover(int target) {
        int[] num = new int[target + 1];
        if(target == 0) {
            return 0;
        }
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }
        num[0] = 1;
        num[1] = 1;
        num[2] = 2;

        for(int i = 3; i < target + 1; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }

        return num[target];
    }
}
