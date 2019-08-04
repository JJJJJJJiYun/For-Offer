package question_37;

import question_32.BinaryTreePrinter;
import structure.TreeNode;

/**
 * 序列化和反序列化二叉树
 */
public class TreeSerializer {

    private static String serializeTree(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        serializerHelper(root, stringBuilder);
        return stringBuilder.toString();
    }

    private static void serializerHelper(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("$ ");
            return;
        }
        stringBuilder.append(root.value);
        stringBuilder.append(" ");
        serializerHelper(root.left, stringBuilder);
        serializerHelper(root.right, stringBuilder);
    }

    private static TreeNode deserializeTree(String tree) {
        int[] index = new int[1];
        String[] treeNodes = tree.split(" ");
        return deserializeHelper(treeNodes, index);
    }

    private static TreeNode deserializeHelper(String[] treeNodes, int[] index) {
        if (treeNodes[index[0]].equals("$")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(treeNodes[index[0]]));
        index[0]++;
        node.left = deserializeHelper(treeNodes, index);
        node.right = deserializeHelper(treeNodes, index);
        return node;
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
        String tree = serializeTree(node1);
        System.out.println(tree);
        BinaryTreePrinter.printBinaryTree(deserializeTree(tree));
    }

}
