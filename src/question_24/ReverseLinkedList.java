package question_24;

import structure.ListNode;

public class ReverseLinkedList {

    /**
     * 反转链表
     */
    private static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.next.next == null) {
            ListNode result = head.next;
            result.next = head;
            head.next = null;
            return result;
        }
        ListNode i = head, j = head.next, k = head.next.next;
        while (k != null) {
            j.next = i;
            i = j;
            j = k;
            k = k.next;
        }
        j.next = i;
        head.next = null;
        return j;
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
        ListNode head = reverseLinkedList(node1);
        while (head!=null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

}
