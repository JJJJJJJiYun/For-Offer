package question_57;

import java.util.Arrays;

public class SumEqualS {

    /**
     * 找到递增数组中和为 s 的两个数字
     */
    private static int[] findTwoNumbersSumEqualS(int[] array, int s) {
        if (array == null || array.length < 2)
            return null;
        if (array[0] > Math.ceil(s / 2.0))
            return null;
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] < s)
                i++;
            else if (array[i] + array[j] > s)
                j--;
            else
                return new int[]{array[i], array[j]};
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        System.out.println(Arrays.toString(findTwoNumbersSumEqualS(array, 15)));
    }

}
