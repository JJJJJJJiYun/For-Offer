package question_54;

import structure.TreeNode;

public class MaxKNodeOfBinarySearchTree {

    private static int index = 1;

    /**
     * 找到二叉搜索树的第 k 大节点
     */
    private static TreeNode findMaxKNodeOfBinarySearchTree(TreeNode root, int k) {
        if (root == null)
            return null;
        return helper(root, k);
    }

    private static TreeNode helper(TreeNode root, int k) {
        TreeNode theNode = null;
        if (root.left != null)
            theNode = helper(root.left, k);
        if (theNode == null) {
            if (index == k)
                theNode = root;
            index++;
        }
        if (theNode == null && root.right != null)
            theNode = helper(root.right, k);
        return theNode;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(findMaxKNodeOfBinarySearchTree(node1, 5).value);
    }

}
