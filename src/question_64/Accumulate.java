package question_64;

public class Accumulate {

    /**
     * 求 1~n 的和，要求不能使用乘除法、for、while、if、else、switch case 等关键字和条件判断语句
     */
    private static int accumulate(int n) {
        int sum = n;
        boolean b = n > 0 && (sum += accumulate(n - 1)) > 0;
        return sum;
    }

    private static int accumulateWithFormula(int n) {
        return ((int) Math.pow(n, 2) + n) >> 1;
    }

}
