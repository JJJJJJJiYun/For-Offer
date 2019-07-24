package question_26;

import structure.TreeNode;

public class SonOfTree {

    /**
     * 判断传入的树是否为另一树的一部分
     */
    private static boolean isSonOfTree(TreeNode node, TreeNode root) {
        boolean result = false;
        if (root != null) {
            result = helper(node, root);
            if (!result)
                result = isSonOfTree(node, root.left);
            if (!result)
                result = isSonOfTree(node, root.right);
        }
        return result;
    }

    private static boolean helper(TreeNode node, TreeNode root) {
        if (node == null && root == null)
            return true;
        if ((node == null && root != null) || (node != null && root == null))
            return false;
        if (node.value != root.value)
            return false;
        return helper(node.left, root.left) && helper(node.right, root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(2);
        TreeNode node10 = new TreeNode(4);
        TreeNode node11 = new TreeNode(5);
        TreeNode node12 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node9.left = node10;
        node9.right = node11;
        node10.left = node12;
        System.out.println(isSonOfTree(node9, node1));
    }

}
