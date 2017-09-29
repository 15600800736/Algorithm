package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fdh on 2017/9/28.
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int m = matrix.length;
        if (m == 0) {
            return list;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return list;
        }
        int sx = 0, sy = 0, c = n, r = m;
        int i = 0;
        int size = m * n;
        output:
        while(i < size) {
            for (int j = sx; j < c; j++) {
                list.add(matrix[sx][j]);
                i++;
                if (i >= size) {
                    break output;
                }
            }
            if (i >= size) {
                break output;
            }
            for (int j = sy + 1; j < r; j++) {
                list.add(matrix[j][c - 1]);
                i++;
                if (i >= size) {
                    break output;
                }
            }
            if (i >= size) {
                break output;
            }
            for (int j = c - 2; j > sx - 1; j--) {
                list.add(matrix[r - 1][j]);
                i++;
                if (i >= size) {
                    break output;
                }
            }
            if (i >= size) {
                break output;
            }
            for (int j = r - 2; j > sx; j--) {
                list.add(matrix[j][sy]);
                i++;
                if (i >= size) {
                    break output;
                }
            }
            sx++;sy++;c--;r--;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] nums = new int[3][1];

        nums[0][0] = 7;
        nums[1][0] = 9;
        nums[2][0] = 6;
        new SpiralOrder().spiralOrder(nums);
    }

}
