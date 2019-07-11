package question_6;

import structure.ListNode;

public class ListNodeReversePrinter {

    /**
     * 倒序输出链表
     */
    public void reversePrintListNode(ListNode head){
        helper(head);
    }

    private void helper(ListNode head){
        if (head == null)
            return;
        helper(head.next);
        System.out.println(head.value);
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new ListNodeReversePrinter().reversePrintListNode(node1);
    }

}
