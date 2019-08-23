package question_59;

import java.util.*;

/**
 * 一个能够 O(1) 时间复杂度获取最大值的队列
 */
public class MaxValueOfQueue {

    private Deque<Integer> maxDeque = new LinkedList<>();
    private Deque<Integer> dataDeque = new LinkedList<>();

    public void offer(int number) {
        dataDeque.offerLast(number);
        // 即将要存入的元素比当前队列最大值大则存入该元素，小则再将最大值存入一次
        if (maxDeque.isEmpty() || number > maxDeque.peekFirst())
            maxDeque.offerFirst(number);
        else
            maxDeque.offerFirst(maxDeque.peekFirst());
    }

    public void poll() {
        if (dataDeque.isEmpty())
            throw new RuntimeException("队列已空");
        dataDeque.pollFirst();
        maxDeque.pollFirst();
    }

    public int max() {
        if (maxDeque.isEmpty())
            throw new RuntimeException("队列已空");
        return maxDeque.peekFirst();
    }

    /**
     * 输出数组所有长度为 length 的滑动窗口中最大数字的值
     */
    private static int[] getMaxValueOfPartQueue(int[] array, int length) {
        if (array == null || array.length == 0 || length <= 0 || length > array.length)
            return null;
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            // 如果当前下标和队列中的最大值下标超出了滑动窗口范围，那么取出当前的最大值下标
            if (!deque.isEmpty() && i - deque.peek() >= length)
                deque.poll();
            // 将队列中小于当前值的最大值下标都拿出来
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i])
                deque.pollLast();
            deque.offer(i);
            if (!deque.isEmpty() && i >= length - 1)
                list.add(array[deque.peek()]);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }


    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println(Arrays.toString(getMaxValueOfPartQueue(array, 4)));
    }

}
