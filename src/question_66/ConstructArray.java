package question_66;

import java.util.Arrays;

public class ConstructArray {

    /**
     * 用数组 A[n] 构建一个数组 B[n]
     * B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    private static int[] constructArray(int[] array) {
        if (array == null || array.length < 2)
            return array;
        int[] result = new int[array.length];
        result[0] = 1;
        for (int i = 1; i < array.length; i++)
            result[i] = result[i - 1] * array[i - 1];
        int temp = 1;
        for (int i = array.length - 2; i >= 0; i--) {
            temp *= array[i + 1];
            result[i] *= temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(constructArray(array)));
    }

}
