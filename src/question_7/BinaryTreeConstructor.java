package question_7;

import structure.TreeNode;

public class BinaryTreeConstructor {

    /**
     * 从前序和中序遍历结果重建二叉树
     */
    public TreeNode constructBinaryTree(int[] pre, int[] in) {
        return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode helper(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        // 递归终点
        if (ps > pe)
            return null;
        // 先在中序遍历中找到根节点位置
        int rootValue = pre[ps];
        int rootIndex = -1;
        for (int i = is; i <= ie; i++) {
            if (in[i] == rootValue)
                rootIndex = i;
        }
        if (rootIndex == -1)
            throw new RuntimeException("输入错误");
        // 创建根节点
        TreeNode root = new TreeNode(rootValue);
        int leftPartCount = rootIndex - is;
        root.left = helper(pre, ps + 1, ps + leftPartCount, in, is, is + leftPartCount - 1);
        root.right = helper(pre, ps + leftPartCount + 1, pe, in, rootIndex + 1, ie);
        return root;
    }

    // 中序遍历递归打印
    public static void printTree(TreeNode node){
        if(node!=null){
            printTree(node.left);
            System.out.print(node.value+" ");
            printTree(node.right);
        }
    }

    public static void main(String[] args){
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode root = new BinaryTreeConstructor().constructBinaryTree(pre,in);
        printTree(root);
    }

}
