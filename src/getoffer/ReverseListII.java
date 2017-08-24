package getoffer;

/**
 * Created by fdh on 2017/8/24.
 */
public class ReverseListII {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode node = head;
        while(node.next != null) {
            node = node.next;
        }

        ListNode n = iteration(head);
        n.next = null;
        return node;
    }

    private ListNode iteration(ListNode node) {
        if(node.next == null) {
            return node;
        }

        ListNode n = iteration(node.next);
        n.next = node;
        return node;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode r = new ReverseListII().ReverseList(n1);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
