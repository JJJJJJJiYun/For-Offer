package question_18;

import structure.ListNode;

/**
 * 删除链表节点
 */
public class ListNodeDeleter {

    private static ListNode deleteListNode(ListNode head, ListNode target) {
        if (head == null)
            return null;
        if (target == null)
            return head;
        if (head == target) {
            return head.next;
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

    private static void test1() {
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

    private static ListNode deleteDuplicateListNode(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(head.value - 1);
        dummy.next = head;
        ListNode node = dummy;
        while (node != null && node.next != null) {
            ListNode next = node.next;
            if (next.value == node.value) {
                while (next != null && next.value == node.value) {
                    next = next.next;
                }
                // 特殊处理最后一个也被删掉的情况
                if (next == null) {
                    ListNode temp = dummy;
                    while (temp.next != node)
                        temp = temp.next;
                    temp.next = null;
                    node = null;
                } else {
                    node.value = next.value;
                    node.next = next.next;
                }
            } else
                node = node.next;
        }

        return dummy.next;
    }

    private static void test2() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        printListNodes(deleteDuplicateListNode(node1));
    }


    private static void printListNodes(ListNode head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }

}
