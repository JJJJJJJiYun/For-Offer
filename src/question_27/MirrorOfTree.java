package question_27;

import structure.TreeNode;

public class MirrorOfTree {

    private static void generateMirrorOfTree(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        generateMirrorOfTree(root.left);
        generateMirrorOfTree(root.right);
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.println(root.value);
        printTree(root.right);
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
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        printTree(node1);
        generateMirrorOfTree(node1);
        System.out.println("----------镜像后----------");
        printTree(node1);
    }


}
