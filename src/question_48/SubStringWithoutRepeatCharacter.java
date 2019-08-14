package question_48;

public class SubStringWithoutRepeatCharacter {

    /**
     * 找出最长不含重复字符的子字符串
     */
    private static int findSubStringWithoutRepeatCharacter(String str) {
        if (str == null || str.length() == 0)
            return 0;
        if (str.length() == 1)
            return 1;
        char[] chars = str.toCharArray();
        int[] characters = new int[26];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = -1;
        }
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        characters[chars[0] - 'a'] = 0;
        for (int i = 1; i < chars.length; i++) {
            if (characters[chars[i] - 'a'] != -1) {
                int lastIndex = characters[chars[i] - 'a'];
                int gap = i - lastIndex;
                if (gap <= dp[i - 1])
                    dp[i] = gap;
                else
                    dp[i] = dp[i - 1] + 1;
            } else
                dp[i] = dp[i - 1] + 1;
            characters[chars[i] - 'a'] = i;
        }
        int max = Integer.MIN_VALUE;
        for (int num : dp) {
            if (max < num)
                max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findSubStringWithoutRepeatCharacter("aaaaaa"));
    }

}
