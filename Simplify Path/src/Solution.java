import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        //按斜杠划分目录
        String[] dirs = path.split("/");
        //栈
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.equals(".") && !dir.isEmpty()) {
                stack.push(dir);
            }
        }
        //拼接路径
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }
        return sb.length() == 0? "/" : sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String path = "/home/user//Documents/../Pictures";
        String res = s.simplifyPath(path);
        System.out.println(res);
    }
}