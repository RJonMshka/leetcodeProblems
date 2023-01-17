// Leetcode 155. Min Stack

import java.util.Stack;

public class LC155 {

    class StackNode {
        int value;
        int minimum;
        public StackNode(int value, int minimum) {
            this.value = value;
            this.minimum = minimum;
        }
    }

    class MinStack {

        private Stack<StackNode> minStack;

        public MinStack() {
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            if(this.minStack.empty()) {
                this.minStack.push(new StackNode(val, val));
            } else {
                StackNode currentTop = this.minStack.peek();
                this.minStack.push(new StackNode(val, Math.min(val, currentTop.minimum)));
            }
        }

        public void pop() {
            this.minStack.pop();
        }

        public int top() {
            return this.minStack.peek().value;
        }

        public int getMin() {
            return this.minStack.peek().minimum;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
