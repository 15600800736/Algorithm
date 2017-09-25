package leetcode;

/**
 * Created by fdh on 2017/9/23.
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class MergeKList {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length);
    }

    public static ListNode merge(ListNode[] lists, int low, int high) {
        if (high == low) {
            return null;
        }
        if (high - low < 2) {
            return lists[low];
        }
        int mid = (low + high) >> 1;
        ListNode n1 = merge(lists, low, mid);
        ListNode n2 = merge(lists, mid, high);
        ListNode header;
        if (n1 == null && n2 == null) {
            return null;
        } else if (n2 == null || (n1 != null && n2 != null && n1.val <= n2.val)) {
            header = new ListNode(n1.val);
            n1 = n1.next;
        } else if (n1 == null || (n1 != null && n2 != null && n2.val < n1.val)) {
            header = new ListNode(n2.val);
            n2 = n2.next;
        } else {
            return null;
        }
        ListNode n = header;
        while (n1 != null || n2 != null) {
            if (n1 == null || (n1 != null && n2 != null && n1.val > n2.val)) {
                n.next = new ListNode(n2.val);
                n2 = n2.next;
                n = n.next;
                continue;
            }
            if (n2 == null || (n1 != null && n2 != null && n1.val <= n2.val)) {
                n.next = new ListNode(n1.val);
                n1 = n1.next;
                n = n.next;
            }
        }
        return header;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[]{null, null};
        merge(listNodes, 0, listNodes.length);
    }
}
