package question_22;

import structure.ListNode;

public class LastKListNode {

    /**
     * 找出链表的倒数第 K 个节点
     */
    public static ListNode findLastKListNode(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode p = head;
        for (int i = 1; i < k; i++) {
            if (p.next == null)
                return null;
            p = p.next;
        }
        ListNode q = head;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode result = findLastKListNode(node1, 6);
        System.out.println(result == null ? null : result.value);
    }
}
