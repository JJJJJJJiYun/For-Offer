package question_19;

public class Regex {

    /**
     * 正则表达式
     */
    private static boolean match(String str, String pattern) {
        return helper(str, pattern, 0, 0);
    }

    private static boolean helper(String str, String pattern, int strIndex, int patternIndex) {
        if (patternIndex == pattern.length())
            return strIndex == str.length();
        if (pattern.length() - patternIndex == 1)
            return str.length() - strIndex == 1 && (str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.');
        if (pattern.charAt(patternIndex + 1) != '*') {
            if (strIndex == str.length())
                return false;
            return helper(str, pattern, strIndex + 1, patternIndex + 1) && (str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.');
        }
        while (strIndex < str.length() && (str.charAt(strIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.')) {
            if (helper(str, pattern, strIndex, patternIndex + 2))
                return true;
            strIndex++;
        }
        return helper(str, pattern, strIndex, patternIndex + 2);
    }

    public static void main(String[] args) {
        System.out.println(match("a", "ab*"));
    }

}
