package question_53;

public class NumberFinder {

    /**
     * 在递增数组中统计一个数字出现的个数
     */
    private static int countNumOccurrence(int[] array, int num) {
        if (array == null || array.length == 0)
            return 0;

        int first = findNumFirstOccurrence(array, num);
        int last = findNumLastOccurrence(array, num);
        return (first != -1 && last != -1) ? last - first + 1 : 0;
    }

    /**
     * 找到数组中数字第一次出现的位置
     */
    private static int findNumFirstOccurrence(int[] array, int num) {
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] < num)
                start = mid + 1;
            else if (array[mid] > num)
                end = mid - 1;
            else {
                if ((mid > 0 && array[mid - 1] != num) || mid == 0)
                    return mid;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 找到数组中数字最后一次出现的位置
     */
    private static int findNumLastOccurrence(int[] array, int num) {
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] < num)
                start = mid + 1;
            else if (array[mid] > num)
                end = mid - 1;
            else {
                if ((mid < array.length - 1 && array[mid + 1] != num) ||
                        mid == array.length - 1)
                    return mid;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 找到长度为 n-1，数字范围为 0 ~ n-1 且无重复数字的递增数组中
     * 缺失的数字
     */
    private static int findMissingNumber(int[] array) {
        if (array == null || array.length == 0)
            return -1;
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (mid == array[mid])
                start = mid + 1;
            else {
                if (mid == 0 || array[mid - 1] == mid - 1)
                    return mid;
                end = mid - 1;
            }

        }
        if (start == array.length)
            return start;
        return -1;
    }

    /**
     * 找到递增数组中与下标相同的数字
     */
    private static int findEqualIndexNum(int[] array) {
        if (array == null || array.length == 0)
            throw new RuntimeException("不存在这样的数字");
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] < mid)
                start = mid + 1;
            else if (array[mid] > mid)
                end = mid - 1;
            else
                return mid;
        }
        throw new RuntimeException("不存在这样的数字");
    }

    public static void main(String[] args) {
        int[] array = {4, 4, 4, 4, 5};
        System.out.println(findNumFirstOccurrence(array, 4));
        System.out.println(findNumLastOccurrence(array, 4));
        System.out.println(countNumOccurrence(array, 4));
        int[] array2 = {0};
        System.out.println(findMissingNumber(array2));
        int[] array3 = {-3,-1,1,3,5};
        System.out.println(findEqualIndexNum(array3));
    }

}
