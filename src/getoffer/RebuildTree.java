package getoffer;

/**
 * Created by fdh on 2017/8/23.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class RebuildTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        IntWarpper ri= new IntWarpper();
        return rebuild(pre,ri,0,in.length,in);
    }

    class IntWarpper {
        int i = -1;
    }
    public TreeNode rebuild(int[] pre,IntWarpper ri, int low, int high, int[] in) {
        if(low == high) {
            return null;
        }
        ri.i++;
        for(int i = low; i < high; i++) {
            if(pre[ri.i] == in[i]) {
                TreeNode node = new TreeNode(in[i]);
                node.left = rebuild(pre, ri, low, i, in);
                node.right = rebuild(pre,ri,i+1,high,in);
                return node;
            }
        }
        return null;
    }

}
