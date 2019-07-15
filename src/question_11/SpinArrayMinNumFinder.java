package question_11;

public class SpinArrayMinNumFinder {

    private static int findMinNumInSpinArray(int[] array) {
        int start = 0, end = array.length - 1;
        while (array[start] >= array[end]) {
            if (start == end - 1) {
                ++start;
                break;
            }
            int mid = (start + end) / 2;
            if (array[start] < array[mid])
                start = mid;
            else if (array[start] > array[mid])
                end = mid;
            else {
                int min = Integer.MAX_VALUE;
                for (int num : array) {
                    if (num < min)
                        min = num;
                }
                return min;
            }

        }
        return array[start];
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 0, 1};
        System.out.println(findMinNumInSpinArray(array));
    }

}
