package question_38;

public class StringPermutation {

    /**
     * 输出字符串中字符的所有排列
     */
    private static void permuteString(String str) {
        if (str == null || str.length() == 0)
            return;
        char[] chars = str.toCharArray();
        helper(chars, 0);
    }

    private static void helper(char[] chars, int index) {
        if (index == chars.length) {
            System.out.println(String.valueOf(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            char temp = chars[index];
            chars[index] = chars[i];
            chars[i] = temp;
            helper(chars, index + 1);
            temp = chars[index];
            chars[index] = chars[i];
            chars[i] = temp;
        }
    }

    public static void main(String[] args) {
        permuteString("abc");
    }

}
