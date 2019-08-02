package question_34;

import structure.TreeNode;

import java.util.ArrayList;

public class SumOfTreePath {

    private static void printSumOfTreePath(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>(), 0);
    }

    private static void helper(TreeNode root, int sum, ArrayList<TreeNode> treeNodes, int current) {
        treeNodes.add(root);
        // 如果是叶节点
        if (root.left == null && root.right == null) {
            // 如果路径和等于 sum 则打印
            if (current + root.value == sum) {
                for (TreeNode node : treeNodes) {
                    System.out.print(node.value + " ");
                }
                System.out.println();
            }
        } else {
            if (root.left != null)
                helper(root.left, sum, treeNodes, current + root.value);
            if (root.right != null)
                helper(root.right, sum, treeNodes, current + root.value);
        }
        treeNodes.remove(root);
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
        printSumOfTreePath(node1, 22);
    }

}
