package question_40;

import java.util.PriorityQueue;

public class MinKNumsFinder {

    /**
     * 找出数组中最小的 K 个数
     * 这里用的不改变原数组方法，时间复杂度为 O(nlogk)
     * 改变原数组的方法可将上一题的找中位数改为找第 K 个数，时间复杂度为 O(logn)
     */
    private static int[] findMinKNums(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0)
            return new int[0];
        if (array.length < k)
            return array;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        for (int num : array) {
            if (priorityQueue.size() < k)
                priorityQueue.offer(num);
            else {
                int max = priorityQueue.poll();
                if (max > num)
                    priorityQueue.offer(num);
                else
                    priorityQueue.offer(max);
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 5, 4, 6, 9, 8, 7};
        int[] result = findMinKNums(array, 4);
        for (int num : result)
            System.out.println(num);
    }

}
