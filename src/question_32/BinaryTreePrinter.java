package question_32;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePrinter {

    /**
     * 换行分层打印二叉树
     */
    private static void printBinaryTree(TreeNode root) {
        Queue<TreeNode> helper = new LinkedList<>();
        helper.offer(root);
        int currentLevel = 1, nextLevel = 0;
        while (!helper.isEmpty()) {
            TreeNode current = helper.poll();
            currentLevel--;
            System.out.print(current.value + " ");
            if (current.left != null) {
                nextLevel++;
                helper.offer(current.left);
            }
            if (current.right != null) {
                nextLevel++;
                helper.offer(current.right);
            }
            if (currentLevel == 0) {
                System.out.println();
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }

    /**
     * 之字形打印二叉树
     */
    private static void printBinaryTreeZigZag(TreeNode root) {
        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();
        oddStack.push(root);
        int currentLevel = 1;
        while (!(oddStack.isEmpty() && evenStack.isEmpty())) {
            Stack<TreeNode> currentStack = currentLevel % 2 != 0 ? oddStack : evenStack;
            TreeNode current = currentStack.pop();
            System.out.print(current.value + " ");
            if (currentLevel % 2 != 0) {
                if (current.left != null)
                    evenStack.push(current.left);
                if (current.right != null)
                    evenStack.push(current.right);
            } else {
                if (current.right != null)
                    oddStack.push(current.right);
                if (current.left != null)
                    oddStack.push(current.left);
            }
            if (currentStack.isEmpty()) {
                System.out.println();
                currentLevel++;
            }
        }
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
        printBinaryTree(node1);
        printBinaryTreeZigZag(node1);
    }

}
