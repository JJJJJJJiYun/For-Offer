package question_65;

public class Add {

    /**
     * 不使用加减乘除运算符实现加法
     */
    private static int add(int num1, int num2) {
        // 用 num1 作为运算结果，num2 作为进位
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    private static void swap(int num1, int num2) {
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("num1: " + num1 + " num2: " + num2);
    }

    public static void main(String[] args) {
        System.out.println(add(1, -2));
        swap(1, 2);
    }

}
