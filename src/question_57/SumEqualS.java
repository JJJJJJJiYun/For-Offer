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

    /**
     * 打印和为 s 的连续正数序列
     */
    private static void printNumbersSumEqualS(int s) {
        if (s <= 0)
            return;
        if (s < 3)
            System.out.println(s);
        int p = 1, q = 2, sum = 3, middle = s / 2 + 1;
        while (p < q) {
            if (p > middle)
                break;
            if (sum == s) {
                for (int i = p; i <= q; i++)
                    System.out.print(i + " ");
                System.out.println();
                q++;
                sum += q;
            }
            if (sum < s) {
                q++;
                sum += q;
            }
            if (sum > s) {
                sum -= p;
                p++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        System.out.println(Arrays.toString(findTwoNumbersSumEqualS(array, 15)));
        printNumbersSumEqualS(12);
    }

}
