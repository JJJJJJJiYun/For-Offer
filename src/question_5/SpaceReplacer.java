package question_5;

public class SpaceReplacer {

    /**
     * 将字符串中的空格替换为%20
     */
    private static String replaceSpace(String str) {
        char[] chars = str.toCharArray();
        int spaceCount = 0;
        for (char c : chars) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        char[] newChars = new char[str.length() + 2 * spaceCount];
        int i = 0, j = 0;
        while (i < str.length()) {
            if (chars[i] != ' ')
                newChars[j++] = chars[i++];
            else {
                newChars[j++] = '%';
                newChars[j++] = '2';
                newChars[j++] = '0';
                i++;
            }
        }
        return String.valueOf(newChars);
    }

    public static void main(String[] args) {
        String str = "ljy is a pig";
        System.out.println(replaceSpace(str));
    }

}
