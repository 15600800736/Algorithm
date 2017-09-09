package didi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fdh on 2017/9/9.
 */
public class Maze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int p = scanner.nextInt();

            int[][] maze = new int[n][m];
            List<String> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }

//            int[][] dp = new int[n][m];
//
//            dp[0][0] = 0;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (maze[i][j] == 0) {
//                        // means cannot get here
//                        dp[i][j] = p + 1;
//                        continue;
//                    }
//                    if (i - 1 >= 0 && maze[i - 1][j] == 1) {
//                        dp[i][j] = dp[i - 1][j];
//                    } else if ((j - 1 >= 0 && j + 1 < m) && (maze[i][j - 1] == 1 || maze[i][j + 1] == 1)) {
//                        if (maze[i][j - 1] == 1 && maze[i][j + 1] == 1) {
//                            dp[i][j] = Math.min(dp[i][j - 1], dp[i][j + 1]) + 1;
//                        } else if (maze[i][j - 1] == 1) {
//                            dp[i][j] = dp[i][j - 1] + 1;
//                        } else if (maze[i][j + 1] == 1) {
//                            dp[i][j] = dp[i][j + 1] + 1;
//                        }
//                    } else if (j - 1 >= 0 && maze[i][j - 1] == 1) {
//                        dp[i][j] = dp[i][j - 1] + 1;
//                    } else if (j + 1 < m && maze[i][j + 1] == 1) {
//                        dp[i][j] = dp[i][j + 1] + 1;
//                    } else if (i + 1 < n && maze[i + 1][j] == 1) {
//                        dp[i][j] = dp[i + 1][j] + 3;
//                    } else {
//                        System.out.println("题错了");
//                        return;
//                    }
//                }
//            }
//            System.out.println(dp[0][m - 1] > p ? "");
            int x = 0, y = 0;
            int minP = 0;
            while (x != 0 || y != m - 1) {
                // 尽量向右
                if (x + 1 < m && maze[x + 1][y] == 1) {
                    x++; minP++;
                // 优先选择向上，因为每向下一次最后都要向上补回来
                } else if (y - 1 >= 0 && maze[x][y - 1] == 1) {
                    y--; minP +=3;
                // 若不行，则选择向下，并标记回头路
                } else if (y + 1 < n && maze[x + 1][y] == 1) {
                    maze[x][y] = 0;
                    y++;
                // 无可奈何，向左，并标记回头路
                } else {
                    maze[x][y] = 0;

                }
            }
        }
    }
}
