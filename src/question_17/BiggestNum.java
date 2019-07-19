package question_17;

public class BiggestNum {

    /**
     * 按序输出从 1 到 n 位数字的最大数字
     */
    private static void generateBiggestNum(int n) {
        char[] chars = new char[n + 1];
        for (int i = 0; i <= n; i++) {
            chars[i] = '0';
        }
        while (true) {
            if (chars[n] != '9')
                chars[n]++;
            else {
                int i = n;
                while (chars[i] == '9') {
                    chars[i] = '0';
                    i--;
                }
                chars[i]++;
            }
            if (chars[0] == '1')
                break;
            System.out.println(Integer.parseInt(String.valueOf(chars)));
        }
    }

    public static void main(String[] args) {
        generateBiggestNum(3);
    }

}
