package getoffer;

/**
 * Created by fdh on 2017/8/21.
 */
public class Find {
    public boolean find(int target, int[][] array) {
        int r = 0;
        int c = array[0].length - 1;
        while (r < array.length && c > -1) {
            int candidate = array[r][c];
            if(target == candidate) {
                return true;
            }
            if (target > candidate) {
                r++;
            } else if(target < candidate) {
                c--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        new Find().find(5, arr);
    }
}
