package question_14;

/**
 * 在绳子上剪任意段并找到各段长度乘积的最大值
 */
public class RopeCutter {

    private static int cutRopeWithDP(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        // f(n) = max(f(i) * f(n-i))
        int[] result = new int[length + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i = 4; i <= length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                int temp = result[j] * result[i - j];
                max = temp > max ? temp : max;
            }
            result[i] = max;
        }
        return result[length];
    }

    // 贪婪算法，尽可能多的剪 3
    private static int cutRopeWithGreedy(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int timeOfThree = length / 3;
        int timeOfTwo = 0;
        if (length % 3 == 1) {
            timeOfTwo = 2;
            timeOfThree--;
        }
        if (length % 3 == 2) {
            timeOfTwo = 1;
        }
        return (int) (Math.pow(3, timeOfThree) * Math.pow(2, timeOfTwo));

    }

    public static void main(String[] args) {
        System.out.println(cutRopeWithDP(5));
        System.out.println(cutRopeWithGreedy(5));
    }

}
