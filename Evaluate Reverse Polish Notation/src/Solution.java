import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            } else if ("-".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if ("*".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            } else if ("/".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = s.evalRPN(tokens);
        System.out.println(result);
    }
}