package question_41;

import java.util.PriorityQueue;

public class MedianFinder {

    /**
     * 找到数组中位数
     */
    private static double findMedian(int[] array) {
        if (array == null || array.length == 0)
            throw new RuntimeException("数组为空");
        if (array.length == 1)
            return array[0];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                if (!minHeap.isEmpty() && minHeap.peek() < array[i]) {
                    minHeap.offer(array[i]);
                    maxHeap.offer(minHeap.poll());
                } else
                    maxHeap.offer(array[i]);
            } else {
                if (!maxHeap.isEmpty() && maxHeap.peek() > array[i]) {
                    maxHeap.offer(array[i]);
                    minHeap.offer(maxHeap.poll());
                } else
                    minHeap.offer(array[i]);
            }
        }
        int min = minHeap.peek();
        int max = maxHeap.peek();
        return array.length % 2 != 0 ? max : (min + max) / 2.0;
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 2, 1, 4, 7, 3, 5, 8};
        System.out.println(findMedian(array));
    }

}
