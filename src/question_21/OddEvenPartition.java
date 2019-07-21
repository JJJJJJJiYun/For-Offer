package question_21;

public class OddEvenPartition {

    /**
     * 将奇数和偶数分割，奇数在前偶数在后
     */
    private static void partOddEven(int[] array) {
        if (array == null || array.length == 0 || array.length == 1)
            return;
        int i = 0, j = array.length - 1;
        while (true) {
            while (array[i] % 2 != 0)
                i++;
            while (array[j] % 2 == 0)
                j--;
            if (i >= j) break;
            int temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 1};
        partOddEven(array);
        for (int num : array)
            System.out.println(num);
    }

}
