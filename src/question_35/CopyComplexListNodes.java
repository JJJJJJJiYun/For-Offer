package question_35;

import structure.ComplexListNode;

public class CopyComplexListNodes {

    private static ComplexListNode copyComplexListNodes(ComplexListNode head) {
        if (head == null)
            return null;
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode copyOfNode = new ComplexListNode(node.value);
            copyOfNode.next = node.next;
            node.next = copyOfNode;
            node = node.next.next;
        }
        node = head;
        while (node != null) {
            if (node.sibling != null)
                node.next.sibling = node.sibling.next;
            node = node.next.next;
        }
        node = head;
        ComplexListNode newHead = head.next;
        while (node.next.next != null) {
            ComplexListNode nextNode = node.next.next;
            ComplexListNode nextNewNode = node.next.next.next;
            node.next = nextNode;
            node.next.next = nextNewNode;
            node = nextNode;
        }
        node.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);
        node1.next = node2;
        node1.sibling = node3;
        node2.next = node3;
        node2.sibling = node5;
        node3.next = node4;
        node4.next = node5;
        node4.sibling = node2;
        ComplexListNode newHead = copyComplexListNodes(node1);
        System.out.println(newHead.value);
    }

}
