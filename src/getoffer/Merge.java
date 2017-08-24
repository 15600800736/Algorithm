package getoffer;

/**
 * Created by fdh on 2017/8/24.
 */
public class Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list2 != null && list1.val < list2.val)) {
                result.next = new ListNode(list1.val);
                result = result.next;
                list1 = list1.next;
                continue;
            }
            if (list1 == null || (list1 != null && list2 != null && list2.val <= list1.val)) {
                result.next = new ListNode(list2.val);
                result = result.next;
                list2 = list2.next;
            }

        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n3;
        n3.next = n5;

        n2.next = n4;
        n4.next = n6;

        ListNode n = new Merge().Merge(n1, n2);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }

    }
}
