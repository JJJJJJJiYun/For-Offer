package question_63;

public class MaxProfit {

    private static int getMaxProfit(int[] array) {
        if (array == null || array.length < 2)
            return 0;
        int min = array[0];
        int max = array[1] - array[0];
        for (int i = 2; i < array.length; i++) {
            if (array[i - 1] < min)
                min = array[i - 1];
            max = Math.max(max, array[i] - min);

        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {16, 11, 7, 4, 2, 1};
        System.out.println(getMaxProfit(array));
    }

}
