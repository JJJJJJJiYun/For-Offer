package question_10;

/**
 * 斐波那契
 */
public class Fibonacci {

    private static int fibonacciWithRecursion(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacciWithRecursion(n - 1) + fibonacciWithRecursion(n - 2);
    }

    private static int fibonacciWithArray(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int former = 0, latter = 1, result = 0;
        for (int i = 1; i < n; i++) {
            result = former + latter;
            former = latter;
            latter = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciWithRecursion(5));
        System.out.println(fibonacciWithArray(5));
    }

}
