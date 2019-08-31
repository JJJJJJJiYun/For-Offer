package question_8;

import structure.TreeNodeWithFather;

public class NextTreeNodeFinder {

    /**
     * 找出中序遍历的下一个节点
     */
    private static TreeNodeWithFather findNextTreeNode(TreeNodeWithFather root) {
        if (root == null)
            return null;
        // 如果存在右子节点，下一个节点一定是右子节点
        if (root.right != null) {
            TreeNodeWithFather temp = root.right;
            while (temp.left != null)
                temp = temp.left;
            return temp;
        }
        // 如果不存在右子节点，且是父节点的左子节点，下一个节点一定是父节点
        if (root == root.father.left)
            return root.father;
        // 如果不存在右子节点，且是父节点的右子节点，向上寻找
        while (root != null) {
            if (root.father == null)
                return null;
            if (root == root.father.left)
                return root.father;
            root = root.father;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNodeWithFather node1 = new TreeNodeWithFather(1);
        TreeNodeWithFather node2 = new TreeNodeWithFather(2);
        TreeNodeWithFather node3 = new TreeNodeWithFather(3);
        TreeNodeWithFather node4 = new TreeNodeWithFather(4);
        TreeNodeWithFather node5 = new TreeNodeWithFather(5);
        TreeNodeWithFather node6 = new TreeNodeWithFather(6);
        TreeNodeWithFather node7 = new TreeNodeWithFather(7);
        TreeNodeWithFather node8 = new TreeNodeWithFather(8);
        TreeNodeWithFather node9 = new TreeNodeWithFather(9);
        node1.setRelation(null, node2, node3);
        node2.setRelation(node1, node4, node5);
        node3.setRelation(node1, node6, node7);
        node5.setRelation(node2, node8, node9);
        TreeNodeWithFather nextNode = findNextTreeNode(node6);
        System.out.println(nextNode == null ? "无下一个节点" : nextNode.value);
    }

}
