package question_56;

import java.util.Arrays;

public class OccurrenceOfNumber {

    /**
     * 找到数组中只出现一次的两个数字，数组中只有两个出现一次的数字，其他均出现两次
     */
    private static int[] findTwoOccurOnceNumbers(int[] array) {
        if (array == null || array.length < 2)
            return null;
        // 获得异或结果为 1 的那一位
        int orResult = 0;
        for (int num : array)
            orResult ^= num;
        String binaryOrResult = Integer.toBinaryString(orResult);
        int index = binaryOrResult.length() - 1;
        for (int i = 0; i < binaryOrResult.length(); i++) {
            if (binaryOrResult.charAt(i) == '1')
                break;
            index--;
        }

        // 根据这个位将数组分割成两部分进行异或
        int num1 = 0, num2 = 0;
        for (int num : array) {
            if ((num >> index & 1) == 0b1)
                num1 ^= num;
            else
                num2 ^= num;
        }
        return new int[]{num1, num2};
    }

    /**
     * 找出一个数组中只出现一次的数字，数组中只有一个出现一次的数字，其他均出现三次
     */
    private static int findOccurOnceNumber(int[] array) {
        if (array == null || array.length < 2)
            throw new RuntimeException("错误的数组");
        // 获取数组中所有数按位相加的和
        int[] bitSum = new int[32];
        for (int num : array) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                if ((num & bitMask) != 0)
                    bitSum[j]++;
                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < bitSum.length; i++) {
            result = result + (bitSum[i] % 3 == 0 ? 0 : (int) Math.pow(2, 31 - i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        System.out.println(Arrays.toString(findTwoOccurOnceNumbers(array)));
        int[] array2 = {6, 1, 2, 1, 2, 1, 2};
        System.out.println(findOccurOnceNumber(array2));
    }

}
