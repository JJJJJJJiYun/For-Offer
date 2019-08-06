package question_42;

public class MaxSumOfSonArray {

    /**
     * 找到和最大的子数组
     */
    private static int findMaxSumOfSonArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int[] dp = new int[array.length + 1];
        dp[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (dp[i] > 0)
                dp[i + 1] = dp[i] + array[i];
            else
                dp[i + 1] = array[i];
        }
        int max = Integer.MIN_VALUE;
        for (int num : dp) {
            if (num > max)
                max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findMaxSumOfSonArray(array));
    }

}
