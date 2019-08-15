package question_50;

public class FirstAppearOnceCharacter {

    /**
     * 找到第一个只出现一次的字符
     */
    private static char findFirstAppearOnceCharacter(String str) {
        if (str == null || str.length() == 0)
            return '\0';
        int[] appearance = new int[256];
        for (int i = 0; i < str.length(); i++) {
            appearance[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (appearance[str.charAt(i)] == 1)
                return str.charAt(i);
        }
        return '\0';
    }

    public static void main(String[] args) {
        System.out.println(findFirstAppearOnceCharacter("abaccdeff"));
    }

}
