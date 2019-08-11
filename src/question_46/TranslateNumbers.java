package question_46;

public class TranslateNumbers {

    /**
     * 计算将数字翻译成字符串的可能方法个数
     */
    private static int countWaysToTranslateNumbersToString(String numbers) {
        if (numbers == null || numbers.length() == 0)
            return 0;
        if (numbers.length() == 1)
            return 1;
        char[] chars = numbers.toCharArray();
        if (chars[0] == '-')
            return 0;
        int[] dp = new int[chars.length + 1];
        dp[chars.length] = 1;
        dp[chars.length - 1] = 1;
        for (int i = chars.length - 2; i >= 0; i--) {
            int temp = (chars[i] - '0') * 10 + (chars[i + 1] - '0');
            if (temp > 9 && temp < 26)
                dp[i] = dp[i + 1] + dp[i + 2];
            else
                dp[i] = dp[i + 1];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(countWaysToTranslateNumbersToString("101"));
    }

}
