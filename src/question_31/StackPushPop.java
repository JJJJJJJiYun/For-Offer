package question_31;

import java.util.Stack;

public class StackPushPop {

    /**
     * 判断弹栈序列是否满足压栈序列
     */
    private static boolean isPopFitPush(int[] push, int[] pop) {
        if (push.length != pop.length)
            return false;
        Stack<Integer> helper = new Stack<>();
        int i = 0, j = 0;
        while (true) {
            // 如果弹出序列找完了，说明正确
            if (i == pop.length)
                return true;
            // 如果辅助栈不为空且栈顶数字等于当前弹栈数字，弹出
            if (!helper.empty() && helper.peek() == pop[i]) {
                helper.pop();
                i++;
                continue;
            }
            boolean flag = false;
            // 将当前弹栈数字之前的数字压进辅助栈
            while (j < push.length) {
                if (push[j] == pop[i]) {
                    j++;
                    i++;
                    flag = true;
                    break;
                }
                helper.push(push[j]);
                j++;
            }
            if (!flag)
                return false;
        }
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        System.out.println(isPopFitPush(push, pop));
    }

}
