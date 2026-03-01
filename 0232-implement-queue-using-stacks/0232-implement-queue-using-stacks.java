import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element to back of queue
    public void push(int x) {
        stack1.push(x);
    }

    // Move elements only when needed
    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    // Remove front element
    public int pop() {
        shiftStacks();
        return stack2.pop();
    }

    // Get front element
    public int peek() {
        shiftStacks();
        return stack2.peek();
    }

    // Check if queue empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}