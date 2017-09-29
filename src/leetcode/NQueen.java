package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by fdh on 2017/9/28.
 */
public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        solveNQueens(n, result, true);
        return null;
    }

    private void solveNQueens(int n, List<List<String>> result, boolean isValid) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        boolean valid = true;
        while (true) {
            if (valid) {

            }
        }

    }

    private void swap(int[] ints, int i, int j) {
        if(i == j) {
            return;
        }
        ints[i] ^= ints[j];
        ints[j] ^= ints[i];
        ints[i] ^= ints[j];
    }
}
