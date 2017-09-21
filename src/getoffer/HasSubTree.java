package getoffer;

/**
 * Created by fdh on 2017/9/13.
 */

public class HasSubTree {
    static class Node {
        int val;
        Node l;
        Node r;
    }

    public static boolean hasSubTree(Node root, Node r) {
        if (root == null || r == null) {
            return false;
        }

        boolean result = false;
        if (root.val == r.val) {
            result = doesTreeContains(root, r);
        }
        if (!result) {
            result = hasSubTree(root.l, r);
        }
        if (!result) {
            result = hasSubTree(root.r, r);
        }
        return result;

    }

    public static boolean doesTreeContains(Node root, Node r) {
        if (root == r && root == null) {
            return true;
        }
        if (root.val == r.val) {
            return doesTreeContains(root.l, r.l) && doesTreeContains(root.r, r.r);
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
