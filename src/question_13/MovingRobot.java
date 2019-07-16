package question_13;

public class MovingRobot {

    /**
     * 找到矩阵中坐标按位取和小于预设值的最长路径
     */
    private static int countReachableCube(int rows, int cols, int limit) {
        if (limit < 0) return 0;
        boolean[][] array = new boolean[rows][cols];
        return helper(array, 0, 0, limit);
    }

    private static int helper(boolean[][] array, int i, int j, int limit) {
        array[i][j] = true;
        int up = 0, down = 0, left = 0, right = 0;
        // 向上
        if (i - 1 >= 0 && (digitSum(i - 1) + digitSum(j)) <= limit && !array[i - 1][j])
            up = helper(array, i - 1, j, limit);
        // 向下
        if (i + 1 < array.length && (digitSum(i + 1) + digitSum(j)) <= limit && !array[i + 1][j])
            down = helper(array, i + 1, j, limit);
        // 向左
        if (j - 1 >= 0 && (digitSum(i) + digitSum(j - 1)) <= limit && !array[i][j - 1])
            left = helper(array, i, j - 1, limit);
        // 向右
        if (j + 1 < array[0].length && (digitSum(i) + digitSum(j + 1)) <= limit && !array[i][j + 1])
            right = helper(array, i, j + 1, limit);
        return 1 + up + down + left + right;
    }

    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countReachableCube(20, 20, 15));
    }
}
