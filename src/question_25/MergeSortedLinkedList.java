package question_25;

import structure.ListNode;

public class MergeSortedLinkedList {

    /**
     * 合并两个有序链表
     */
    private static ListNode mergeSortedLinkedList(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null)
            return null;
        if (head1 != null && head2 == null)
            return head1;
        if (head1 == null && head2 != null)
            return head2;
        ListNode dummy = new ListNode(Math.min(head1.value, head2.value) - 1);
        ListNode node = dummy;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        if (head1 != null)
            node.next = head1;
        else
            node.next = head2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3_1 = new ListNode(3);
        ListNode node3_2 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3_1;
        node3_2.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode node = mergeSortedLinkedList(node1, node3_2);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }


}
