package question_39;

public class MostFrequentlyShowNumFinder {

    /**
     * 找到一个数组中出现次数超过一半的数
     */
    private static int findMostFrequentlyShowNum(int[] array) {
        int left = 0, right = array.length - 1;
        int index;
        while (true) {
            index = getIndex(array, left, right);
            if (index < array.length / 2)
                left = index + 1;
            else if (index > array.length / 2)
                right = index - 1;
            else
                break;
        }
        return array[index];
    }

    private static int findMostFrequentlyShowNum2(int[] array) {
        int result = -1, count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                result = array[i];
                count++;
            } else {
                if (array[i] == array[i - 1])
                    count++;
                else
                    count--;
            }
        }
        return result;
    }

    /**
     * 快速排序
     */
    private static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left > right)
            return;
        int index = getIndex(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    /**
     * 找到一个数在一个数组中的正确索引位置
     */
    private static int getIndex(int[] array, int left, int right) {
        // 基准数据
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot)
                right--;
            array[left] = array[right];
            while (left < right && array[left] <= pivot)
                left++;
            array[right] = array[left];
        }
        // 跳出循环时 left 和 right 相等,此时的 left 或 right 就是 pivot 的正确索引位置
        array[left] = pivot;
        return left;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(findMostFrequentlyShowNum2(array));
        System.out.println("--------------------");
        System.out.println(findMostFrequentlyShowNum(array));
        System.out.println("--------------------");
        int[] array2 = {3, 1, 2, 6, 5, 4};
        quickSort(array2);
        for (int num : array2)
            System.out.println(num);
    }

}