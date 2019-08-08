package question_45;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumArray {

    /**
     * 获取一个数组中所有数字组成的数字值最小的排列
     */
    private static String generateMinNumArray(int[] array) {
        if (array == null || array.length == 0)
            return "";
        if (array.length == 1)
            return String.valueOf(array[0]);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                char[] num1Chars = String.valueOf(o1).toCharArray();
                char[] num2Chars = String.valueOf(o2).toCharArray();
                int length = num1Chars.length > num2Chars.length ? num1Chars.length : num2Chars.length;
                for (int i = 0; i < length; i++) {
                    int temp1 = i >= num1Chars.length ? num1Chars[num1Chars.length - 1] : num1Chars[i];
                    int temp2 = i >= num2Chars.length ? num2Chars[num2Chars.length - 1] : num2Chars[i];
                    if (temp1 < temp2)
                        return -1;
                    else if (temp1 > temp2)
                        return 1;
                }
                return 0;
            }
        };
        Integer[] integers = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            integers[i] = array[i];
        }
        Arrays.sort(integers, comparator);
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : integers) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] array = {3, 323, 32123};
        System.out.println(generateMinNumArray(array));
    }

}
