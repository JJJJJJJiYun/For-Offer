package question_4;

public class NumFinder {
    /**
     * 在二维数组中
     * 从左到右递增
     * 从上到下递增
     * 输入一个数判断是否存在
     */
    private static boolean existNum(int[][] array, int num) {
        int i = 0, j = array.length - 1;
        while (i < array.length && j >= 0) {
            if (array[i][j] == num)
                return true;
            else if (array[i][j] > num)
                j--;
            else
                i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(existNum(array, 4));
        System.out.println(existNum(array, 5));
    }
}
