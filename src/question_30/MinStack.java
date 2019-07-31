package question_30;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> elements = new Stack<>();
    private Stack<Integer> minElements = new Stack<>();

    public void push(int element) {
        elements.push(element);
        int min = minElements.peek() > element ? element : minElements.peek();
        minElements.push(min);
    }

    public int pop() {
        int element = elements.pop();
        minElements.pop();
        return element;
    }

    public int min() {
        return minElements.peek();
    }


}
