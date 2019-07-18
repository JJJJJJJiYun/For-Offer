package question_18;

import structure.ListNode;

public class ListNodeDeleter {

    private static ListNode deleteListNode(ListNode head, ListNode target) {
        if (head == target) {
            return null;
        }
        if (target.next == null) {
            ListNode pre = head;
            ListNode node = head.next;
            while (node.next != null) {
                node = node.next;
                pre = pre.next;
            }
            pre.next = null;
            return head;
        }
        target.value = target.next.value;
        target.next = target.next.next;
        return head;
    }

    private static void printListNodes(ListNode head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
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
        System.out.println("----------删除中间节点----------");
        printListNodes(deleteListNode(node1, node3));
        System.out.println("----------删除最后节点----------");
        printListNodes(deleteListNode(node1, node5));
        System.out.println("----------删除头节点----------");
        printListNodes(deleteListNode(node6, node6));

    }

}
