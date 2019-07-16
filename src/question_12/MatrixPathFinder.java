package question_12;

public class MatrixPathFinder {

    /**
     * 判断矩阵是否存在组成字符串的路径
     */
    private static boolean findPathInMatrix(char[][] array, String str) {
        if (array == null || array.length == 0 || array[0] == null || array[0].length == 0)
            return false;
        boolean[][] isVisited = new boolean[array.length][array[0].length];
        char[] chars = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (helper(array, i, j, chars, 0, isVisited))
                    return true;
            }
        }
        return false;
    }

    private static boolean helper(char[][] array, int i, int j, char[] chars, int depth, boolean[][] isVisited) {
        if (depth == chars.length)
            return true;
        isVisited[i][j] = true;
        boolean up = false, down = false, left = false, right = false;
        // 向上
        if (i - 1 >= 0 && array[i - 1][j] == chars[depth] && !isVisited[i - 1][j])
            up = helper(array, i - 1, j, chars, depth + 1, isVisited);
        // 向下
        if (i + 1 < array.length && array[i + 1][j] == chars[depth] && !isVisited[i + 1][j])
            down = helper(array, i + 1, j, chars, depth + 1, isVisited);
        // 向左
        if (j - 1 >= 0 && array[i][j - 1] == chars[depth] && !isVisited[i][j - 1])
            left = helper(array, i, j - 1, chars, depth + 1, isVisited);
        // 向右
        if (j + 1 < array[0].length && array[i][j + 1] == chars[depth] && !isVisited[i][j + 1])
            right = helper(array, i, j + 1, chars, depth + 1, isVisited);
        isVisited[i][j] = false;
        return up || down || left || right;
    }

    public static void main(String[] args) {
        char[][] array = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        System.out.println(findPathInMatrix(array, "bbfg"));
    }

}
