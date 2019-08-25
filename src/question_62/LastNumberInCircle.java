package question_62;

public class LastNumberInCircle {

    /**
     * 对于 0~n-1 的数字组成的还，从 0 开始取出第 m 个数
     * 求最后剩下的数字
     */
    private static int getLastNumberInCircle(int n, int m) {
        int[] helper = new int[n];
        for (int i = 0; i < n; i++)
            helper[i] = i;
        int i = 0;
        int modified = 1;
        while (modified < n) {
            int step = 1;
            while (step < m) {
                while (helper[i] == -1) {
                    i = increaseWithCheck(i, n);
                }
                i = increaseWithCheck(i, n);
                step++;
            }
            while (helper[i] == -1) {
                i = increaseWithCheck(i, n);
            }
            helper[i] = -1;
            i = increaseWithCheck(i, n);
            modified++;
        }
        for (int num : helper) {
            if (num != -1)
                return num;
        }
        return -1;
    }

    // 纯数学解法 背下来

    private static int getLastNumberWithMath(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int last = 0;
        for (int i = 2; i <= n; i++)
            last = (last + m) % i;
        return last;
    }

    private static int increaseWithCheck(int i, int n) {
        i++;
        if (i == n)
            i = 0;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(getLastNumberInCircle(4000, 997));
    }

}
