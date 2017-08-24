package getoffer;

/**
 * Created by fdh on 2017/8/24.
 */



public class FindKthToTail {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    class IntegerWrapper {
        int integer;
    }
    public ListNode findKthToTail(ListNode head, int k) {
        return iteration(head,new IntegerWrapper(), k);
    }

    public ListNode iteration(ListNode node, IntegerWrapper integerWrapper, int k) {
        if(node == null) {
            return null;
        }
        ListNode result = iteration(node.next, integerWrapper, k);
        if(result == null) {
            if(++integerWrapper.integer == k) {
                return node;
            } else {
                return null;
            }
        } else {
            return result;
        }
    }
}
