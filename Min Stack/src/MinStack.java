import java.util.Objects;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        //使用equels判断是否相等,改为 ==，它只会在两个对象的引用相同时返回 true，即它们指向的是内存中的同一个对象
         if (Objects.equals(stack.peek(), minStack.peek())) {
             minStack.pop();
         }
         stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
         return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}