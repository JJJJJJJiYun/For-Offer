package question_52;

import structure.ListNode;

public class FirstSharedNode {

    /**
     * 找到两个链表的第一个共同节点
     * @param head1
     * @param head2
     * @return
     */
    private static ListNode findFirstSharedNode(ListNode head1, ListNode head2) {
        int count1 = 0, count2 = 0;
        ListNode p = head1, q = head2;
        while (p != null) {
            count1++;
            p = p.next;
        }
        while (q != null) {
            count2++;
            q = q.next;
        }
        // p 是长的， q 是短的
        p = count1 > count2 ? head1 : head2;
        q = count1 > count2 ? head2 : head1;
        for (int i = 0; i < Math.abs(count1 - count2); i++) {
            p = p.next;
        }
        while (p != null) {
            if (p == q)
                return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node6.next = node7;
        node7.next = node3;
        ListNode result = findFirstSharedNode(node1, node6);
        System.out.println(result == null ? null : result.value);

    }

}
