package question_58;

import java.util.Arrays;

public class ReverseString {

    /**
     * 反转字符串中的单词
     */
    private static char[] reverseWords(char[] sentence) {
        if (sentence == null || sentence.length == 0)
            return sentence;
        reverse(sentence, 0, sentence.length - 1);
        int start = 0;
        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i] == ' ') {
                reverse(sentence, start, i - 1);
                start = i + 1;
            }
        }
        reverse(sentence, start, sentence.length - 1);
        return sentence;
    }

    private static char[] reverseWords(char[] sentence, int index) {
        if (sentence == null || sentence.length == 0)
            return sentence;
        if (index < 0 || index >= sentence.length)
            return sentence;
        reverse(sentence, 0, index - 1);
        reverse(sentence, index, sentence.length - 1);
        reverse(sentence, 0, sentence.length - 1);
        return sentence;
    }

    private static void reverse(char[] sentence, int start, int end) {
        while (start < end) {
            char temp = sentence[end];
            sentence[end--] = sentence[start];
            sentence[start++] = temp;
        }
    }

    public static void main(String[] args) {
        char[] sentence = "abc is a student.".toCharArray();
        char[] sentence2 = "abcdefg".toCharArray();
        System.out.println(String.valueOf(reverseWords(sentence)));
        System.out.println(String.valueOf(reverseWords(sentence2, 1)));
    }

}
