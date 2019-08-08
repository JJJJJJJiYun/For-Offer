package question_43;

import java.util.Arrays;

public class OneCounter {

    /**
     * 计算 1-n 中所有数字中 1 的个数
     * 这道题纯靠逻辑，个人觉得面试并不会出
     */
    private static int countOne(int n) {
        if (n < 0)
            return 0;
        char[] chars = String.valueOf(n).toCharArray();
        return helper(chars, 0);
    }

    private static int helper(char[] chars, int index) {
        if (index == chars.length)
            return 0;
        int first = chars[index] - '0';
        int length = chars.length - index;
        if (length == 1 && first == 0)
            return 0;
        if (length == 1 && first > 0)
            return 1;
        int numFirstDigit = 0;
        if (first > 1)
            numFirstDigit = (int) Math.pow(10, length - 1);
        else if (first == 1)
            numFirstDigit = Integer.valueOf(String.valueOf(Arrays.copyOfRange(chars, index + 1, chars.length))) + 1;
        int numOtherDigits = first * (length - 1) * (int) Math.pow(10, length - 2);
        int numRecursive = helper(chars, index + 1);
        return numFirstDigit + numOtherDigits + numRecursive;
    }

    public static void main(String[] args) {
        System.out.println(countOne(12));
    }

}
