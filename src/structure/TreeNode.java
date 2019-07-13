package structure;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public void setSons(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}
