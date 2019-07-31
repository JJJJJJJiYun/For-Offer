package question_29;

public class MatrixPrinter {

    /**
     * 顺时针打印一个矩阵
     */
    private static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int index = 0;
        while (index * index < matrix.length && index * index < matrix[0].length) {
            printMatrixCircle(matrix, index);
            index++;
        }

    }

    private static void printMatrixCircle(int[][] matrix, int index) {
        int endX = matrix.length - index - 1, endY = matrix[0].length - index - 1;
        // 向左
        for (int i = index; i <= endY; i++)
            System.out.println(matrix[index][i]);
        // 向下
        if (index < endX) {
            for (int i = index + 1; i <= endX; i++)
                System.out.println(matrix[i][endY]);
            // 向右
            if (index < endY) {
                for (int i = endY - 1; i >= index; i--)
                    System.out.println(matrix[endX][i]);
                // 向上
                if (index < endX - 1)
                    for (int i = endX - 1; i > index; i--)
                        System.out.println(matrix[i][index]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrix(matrix);
    }

}
