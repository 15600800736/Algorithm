package getoffer;

import java.util.ArrayList;

/**
 * Created by fdh on 2017/8/23.
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        reverse(listNode, arrayList);
        return arrayList;
    }

    public void reverse(ListNode node, ArrayList<Integer> list) {
        if(node == null) {
            return;
        }
        reverse(node.next, list);
        list.add(node.val);
    }
}
