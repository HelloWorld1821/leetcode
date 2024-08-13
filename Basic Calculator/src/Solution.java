import java.util.*;

public class Solution {

    private Map<Character, Integer> priority = new HashMap<>();

    public void setprioity() {
        priority.put('(', 0);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
    }

    public int calculate(String s) {
        setprioity();
        //去掉表达式中的空格
        s = s.replaceAll("\\s", "");
        s = handleNegative(s);
        //转换为逆波兰表达式
        List<String> rpn = convertToRPN(s);
        //计算逆波兰表达式
        int result = calculateRPN(rpn);
        return result;
    }

    //处理负号
    public String handleNegative(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                //如果在表达式开头或者前面是括号或者运算符, 则添加0
                if (i == 0 || s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-') {
                    sb.append('0');
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    //转换为逆波兰表达式
    public List<String> convertToRPN(String s) {
        Stack<Character> stack = new Stack<>();
        List<String> output = new ArrayList<>();
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是数字, 则拼接起来
            if (Character.isDigit(c)) {
                num += c;
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    output.add(num);
                    num = "";
                }
            }
            else if (c == '(') {
                stack.push(c);
            }
            //如果是右括号, 弹出栈中所有运算符直到遇到左括号
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek()!= '(') {
                    output.add(String.valueOf(stack.pop()));
                }
                stack.pop();
            }
            //如果是运算符
            else {
                while (!stack.isEmpty() && priority.get(c) <= priority.get(stack.peek())) {
                    output.add(String.valueOf(stack.pop()));
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            output.add(String.valueOf(stack.pop()));
        }
        return output;
    }

    public int calculateRPN(List<String> rpn) {
        Stack<Integer> stack = new Stack<>();
        for (String s : rpn) {
            if (Character.isDigit(s.charAt(0))) {
                stack.push(Integer.parseInt(s));
            }
            else if (s.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            }
            else if (s.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if (s.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            }
            else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "1-(     -2)";
        int result = s.calculate(s1);
        System.out.println(result);
    }
}