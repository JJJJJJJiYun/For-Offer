package question_23;

import structure.ListNode;

public class LoopListNodeFinder {

    /**
     * 找到有环链表的环开始节点
     * （头条面试被问过一次，当时回答的用 HashSet 存起来，如果遇到了重复的就是环开始的节点）
     */
    private static ListNode findLoopStartListNode(ListNode head) {
        // 判断是否有环，并找到一个环中的节点
        ListNode p = head, q = head;
        do {
            if (q == null || q.next == null)
                return null;
            p = p.next;
            q = q.next.next;
        } while (p != q);
        // 计算环中有多少个节点
        int count = 0;
        do {
            q = q.next;
            count++;
        } while (p != q);
        // 找到环开始节点
        p = head;
        q = head;
        for (int i = 0; i < count; i++) {
            q = q.next;
        }
        while (p != q){
            p = p.next;
            q = q.next;
        }
        return p;
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
        node6.next = node5;
        ListNode result = findLoopStartListNode(node1);
        System.out.println(result == null ? null : result.value);
    }


}
