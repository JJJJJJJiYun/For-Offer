package structure;

public class TreeNodeWithFather {
    public int value;
    public TreeNodeWithFather left;
    public TreeNodeWithFather right;
    public TreeNodeWithFather father;

    public TreeNodeWithFather(int value) {
        this.value = value;
    }

    public void setRelation(TreeNodeWithFather father, TreeNodeWithFather left, TreeNodeWithFather right) {
        this.father = father;
        this.left = left;
        this.right = right;
        left.father = this;
        right.father = this;
    }
}
