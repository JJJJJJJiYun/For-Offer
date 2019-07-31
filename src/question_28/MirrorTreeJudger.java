package question_28;

import structure.TreeNode;

public class MirrorTreeJudger {

    /**
     * 判断两树是否互为镜像
     */
    private static boolean isMirrorTree(TreeNode root1, TreeNode root2) {
        return helper(root1, root2);
    }

    private static boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.value != root2.value)
            return false;
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }

}
