package question_55;

import structure.TreeNode;

public class DepthOfTree {

    private static boolean balanced;

    /**
     * 二叉树的深度
     */
    private static int getDepthOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepthOfTree(root.left);
        int right = getDepthOfTree(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 判断是否为平衡二叉树
     */
    private static boolean isBalancedTree(TreeNode root) {
        helper(root);
        return balanced;
    }

    private static int helper(TreeNode root) {
        if (root == null) {
            balanced = true;
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int depth = (left > right) ? left + 1 : right + 1;
        balanced = Math.abs(left - right) <= 1;
        return depth;
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
        System.out.println(getDepthOfTree(node1));
        System.out.println(isBalancedTree(node1));
    }

}
