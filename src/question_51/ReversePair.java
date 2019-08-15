package question_51;

import java.util.Arrays;

public class ReversePair {

    /**
     * 找出数组中的逆序对个数
     * 利用归并排序
     */
    private static int countReversePairs(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int[] copy = new int[array.length];
        return countHelper(array, copy, 0, array.length - 1);
    }

    private static int countHelper(int[] array, int[] copy, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            int left = countHelper(array, copy, start, mid);
            int right = countHelper(array, copy, mid + 1, end);
            int count = countMerger(array, copy, start, mid, end);
            return count + left + right;
        } else
            return 0;
    }

    private static int countMerger(int[] array, int[] copy, int start, int mid, int end) {
        int i = mid, j = end, k = end, count = 0;
        while (i >= start && j > mid) {
            if (array[i] > array[j]) {
                copy[k--] = array[i--];
                count += j - mid;
            } else
                copy[k--] = array[j--];
        }
        while (i >= start)
            copy[k--] = array[i--];
        while (j > mid)
            copy[k--] = array[j--];
        while (end > k) {
            array[end] = copy[end];
            end--;
        }
        return count;
    }

    private static void sort(int[] array) {
        if (array == null || array.length == 0)
            return;
        int[] copy = new int[array.length];
        mergeSort(array, copy, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] copy, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            // 递归下去，直到只有两个数字
            mergeSort(array, copy, start, mid);
            mergeSort(array, copy, mid + 1, end);
            // 将数组分为两半并按序合并
            merge(array, copy, start, mid, end);
        }
    }

    private static void merge(int[] array, int[] copy, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        // 合并
        while (i <= mid && j <= end) {
            if (array[i] < array[j])
                copy[k++] = array[i++];
            else
                copy[k++] = array[j++];
        }
        // 上面的合并可能会出现把一边的数字全部用完了，现在把另一边的也加入数组
        while (i <= mid)
            copy[k++] = array[i++];
        while (j <= end)
            copy[k++] = array[j++];
        k = 0;
        // 将辅助数组中的数字拷贝到原数组
        while (start <= end)
            array[start++] = copy[k++];
    }

    public static void main(String[] args) {
        int[] array = {7, 5, 6, 4};
        System.out.println(countReversePairs(array));
        int[] array2 = {4, 6, 3, 2, 5};
        sort(array2);
        System.out.println(Arrays.toString(array2));
    }

}
