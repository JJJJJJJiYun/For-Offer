package question_47;

public class MostValuableGifts {

    /**
     * 寻找到礼物值最大的路径
     */
    private static int getValueOfMostValuableGifts(int[][] gifts) {
        if (gifts == null || gifts.length == 0 || gifts[0] == null || gifts[0].length == 0)
            return 0;
        int[] dp = new int[gifts[0].length];
        for (int i = 0; i < gifts.length; i++) {
            for (int j = 0; j < gifts[0].length; j++) {
                int up = 0, left = 0;
                if (i > 0)
                    up = dp[j];
                if (j > 0)
                    left = dp[j - 1];
                dp[j] = Math.max(up, left) + gifts[i][j];
            }
        }
        return dp[gifts[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] gifts = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        System.out.println(getValueOfMostValuableGifts(gifts));
    }

}
