package question_3;

public class DuplicateNumber {

    /**
     * 判断长度为 n 的数组中是否存在重复数字
     * 数组中数字大小为 0 ~ n-1
     */
    private static boolean existDuplicateNumber(int[] array) {
        if (array == null || array.length == 0)
            return false;
        for (int num : array) {
            if (num < 0 || num > array.length - 1)
                return false;
        }
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]])
                    return true;
                int tmp = array[i];
                array[i] = array[tmp];
                array[tmp] = tmp;

            }
        }
        return false;
    }

    /**
     * 从长度为 n + 1 的数组中找出重复数字
     * 数组中数字大小为 1 ~ n
     */
    private static int findDuplicateNumber(int[] array) {
        int[] newArray = new int[array.length - 1];
        for (int num : array) {
            if (newArray[num - 1] == num)
                return num;
            newArray[num - 1] = num;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 2, 5, 0, 6};
        System.out.println("---------- 判断数组中是否存在重复数字 ----------");
        System.out.println(existDuplicateNumber(array));
        int[] array2 = new int[]{4, 3, 2, 1, 5, 7, 1, 6};
        System.out.println("---------- 从数组中找到存在的重复数字 ----------");
        System.out.println(findDuplicateNumber(array2));
    }
}
