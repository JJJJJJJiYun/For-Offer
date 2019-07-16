package question_9;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 */
public class QueueByTwoStacks {

    private Stack<Object> stack1;
    private Stack<Object> stack2;

    public QueueByTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public boolean add(Object element) {
        return stack1.push(element) == element;
    }

    public Object poll() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        if (stack2.empty())
            throw new RuntimeException("empty queue");
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueByTwoStacks queueByTwoStacks = new QueueByTwoStacks();
        queueByTwoStacks.add(1);
        queueByTwoStacks.add(2);
        queueByTwoStacks.add(3);
        System.out.println(queueByTwoStacks.poll());
        System.out.println(queueByTwoStacks.poll());
        System.out.println(queueByTwoStacks.poll());
        System.out.println(queueByTwoStacks.poll());
    }

}
