package getoffer;

import java.util.Stack;

/**
 * Created by fdh on 2017/8/23.
 */
public class StackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            if(stack1.isEmpty()) {
                return 0;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
