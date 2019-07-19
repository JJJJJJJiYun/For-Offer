package question_16;

/**
 * 实现 pow 函数
 */
public class Pow {

    private static double pow(double base, int exponent) {
        if (base == 0) {
            if (exponent < 0) {
                throw new RuntimeException("除数不能为负数");
            }
            return 0;
        }
        if (exponent == 0)
            return 1;
        boolean isMinus = false;
        if (exponent < 0) {
            isMinus = true;
            exponent = -exponent;
        }
        return isMinus ? 1 / helper(base, exponent) : helper(base, exponent);
    }

    private static double helper(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double result = helper(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1)
            result *= base;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pow(2.0, -2));
    }

}
