package question_60;

public class DicesProbability {

    private static int MAX_NUM = 6;

    /**
     * 假设有 n 个骰子，输出所有骰子点数和的可能性
     */
    private static void calculateDicesProbability(int n) {
        if (n < 1)
            return;
        int[][] dp = new int[2][MAX_NUM * n + 1];
        for (int i = 1; i <= MAX_NUM; i++) {
            dp[0][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int currentIndex = i % 2 == 0 ? 1 : 0;
            int lastIndex = i % 2 == 0 ? 0 : 1;
            for (int j = 0; j < i - 1; j++)
                dp[lastIndex][j] = 0;
            for (int j = i; j <= i * MAX_NUM; j++) {
                int count = 0;
                for (int k = j - 1; k > 0 && k >= j - 6; k--)
                    count += dp[lastIndex][k];
                dp[currentIndex][j] = count;
            }
        }
        int index = n % 2 == 0 ? 1 : 0;
        for (int i = n; i <= MAX_NUM * n; i++)
            System.out.println(i + ": " + dp[index][i] / Math.pow(MAX_NUM, n));
    }

    public static void main(String[] args) {
        calculateDicesProbability(11);
    }

}
