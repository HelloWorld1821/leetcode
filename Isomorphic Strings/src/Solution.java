
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //定义两个数组，分别从s和t的字符映射和反向映射
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //如果两个字符都没有映射过，则将其映射
            if (map1[c1] == 0 && map2[c2] == 0) {
                map1[c1] = c2;
                map2[c2] = c1;
            }
            //如果两个字符都已经映射过，则判断是否映射正确
            else if (map1[c1] != c2 || map2[c2] != c1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "paper";
        String t1 = "title";
        System.out.println(s.isIsomorphic(s1, t1));
    }
}