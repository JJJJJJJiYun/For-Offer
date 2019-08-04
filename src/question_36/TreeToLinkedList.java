package question_36;

import structure.TreeNode;

public class TreeToLinkedList {

    /**
     * 将二叉搜索树转化为双向链表
     */
    private static TreeNode convertTreeToLinkedList(TreeNode root) {
        // 这个地方用数组来实现全局变量
        TreeNode[] lastNode = new TreeNode[1];
        helper(root, lastNode);
        while (root.left != null)
            root = root.left;
        return root;
    }

    private static void helper(TreeNode root, TreeNode[] lastNode) {
        if (root == null)
            return;
        if (root.left != null)
            helper(root.left, lastNode);
        root.left = lastNode[0];
        if (lastNode[0] != null)
            lastNode[0].right = root;
        lastNode[0] = root;
        if (root.right != null)
            helper(root.right, lastNode);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        TreeNode head = convertTreeToLinkedList(node1);
        while (head != null) {
            System.out.println(head.value);
            head = head.right;
        }

    }

}
