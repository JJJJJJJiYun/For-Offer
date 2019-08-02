package question_33;

import structure.TreeNode;

import java.util.Arrays;

public class PostOrderSequenceOfBinarySearchTreeJudger {

    private static boolean isPostOrderSequence(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return helper(sequence, 0, sequence.length - 1);
    }

    private static boolean helper(int[] sequence, int start, int end) {
        if (end - start < 0)
            return false;
        int root = sequence[end];
        int i = 0;
        // 找到左子树
        while (i < end && sequence[i] < root)
            i++;
        // 在右子树中找错误
        int j;
        for (j = i; j < end - 1; j++) {
            if (sequence[j] < root)
                return false;
        }
        boolean left = true;
        if (i > 0)
            left = helper(sequence, 0, i - 1);
        boolean right = true;
        if (j - i > 0)
            right = helper(sequence, i, j);
        return left && right;
    }

    public static void main(String[] args) {
        int[] sequence = {4, 6, 12, 8, 16, 14, 10};
        System.out.println(isPostOrderSequence(sequence));
    }
}
